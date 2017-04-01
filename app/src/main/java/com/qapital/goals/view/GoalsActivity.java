package com.qapital.goals.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.qapital.QapitalApplication;
import com.qapital.R;
import com.qapital.common.beans.Goal;
import com.qapital.di.QapitalComponent;
import com.qapital.goaldetails.view.GoalDetailsActivity;
import com.qapital.goals.di.GoalsComponent;
import com.qapital.goals.di.GoalsModule;
import com.qapital.goals.presenter.GoalsPresenter;

import java.util.LinkedList;
import java.util.List;

public class GoalsActivity extends AppCompatActivity implements GoalsAdapter.GoalsListener {

  private ProgressBar progressBar;
  GoalsPresenter presenter;
  GoalsView view = new GoalsView() {
    @Override
    public void showProgressBar() {
      progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
      progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void fillUpGoalsList(List<Goal> goals) {
      goalsAdapter.updateGoals(goals);
    }
  };
  private GoalsAdapter goalsAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_goals);
    // Recycler view
    RecyclerView goalsList = (RecyclerView) findViewById(R.id.goals_list);
    goalsList.setHasFixedSize(true);
    goalsList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

    // TODO: 04/01/2017 remove when Rx is implemented
    Goal goal1 = new Goal(230, 1900, "Road Trip",
        "https://images-na.ssl-images-amazon.com/images/I/51S0aQLkDCL.jpg");
    Goal goal2 = new Goal(600, 220000, "Dream house",
        "https://images-na.ssl-images-amazon.com/images/I/51S0aQLkDCL.jpg");
    List<Goal> goals = new LinkedList<>();
    goals.add(goal1);
    goals.add(goal2);
    // Create and sets the adapter
    goalsAdapter = new GoalsAdapter(goals, this);
    goalsList.setAdapter(goalsAdapter);

    //ProgressBar
    progressBar = (ProgressBar) findViewById(R.id.progress);

    //Inject the presenter
    QapitalComponent component = (((QapitalApplication) getApplication())).getQapitalComponent();
    GoalsComponent goalsComponent = component.plus(new GoalsModule());
    presenter = goalsComponent.getGoalsPresenter();
    presenter.setView(view);

    presenter.getGoalsList();
  }

  @Override
  public void onGoalSelected(Goal goal) {
    Intent intent = new Intent(this, GoalDetailsActivity.class);
    intent.putExtra("Goal", goal);
    startActivity(intent);
  }
}
