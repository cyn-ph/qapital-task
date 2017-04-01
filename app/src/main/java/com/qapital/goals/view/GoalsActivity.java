package com.qapital.goals.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

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

    @Override
    public void showError() {
      Toast.makeText(GoalsActivity.this, "Somenthing went wrong!", Toast.LENGTH_SHORT).show();
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
    goalsAdapter = new GoalsAdapter(new LinkedList<Goal>(), this);
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
  protected void onStop() {
    super.onStop();
    presenter.onStop();
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    presenter.onDestroy();
  }

  @Override
  public void onGoalSelected(Goal goal) {
    Intent intent = new Intent(this, GoalDetailsActivity.class);
    intent.putExtra("Goal", goal);
    startActivity(intent);
  }
}
