package com.qapital.goaldetails.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.qapital.QapitalApplication;
import com.qapital.R;
import com.qapital.common.beans.FeedElement;
import com.qapital.common.beans.Goal;
import com.qapital.common.beans.SavingRule;
import com.qapital.common.decorators.BaseItemDecoration;
import com.qapital.di.QapitalComponent;
import com.qapital.goaldetails.di.GoalDetailsComponent;
import com.qapital.goaldetails.di.GoalDetailsModule;
import com.qapital.goaldetails.presenter.GoalDetailsPresenter;
import com.qapital.utils.QapitalUtils;
import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

/**
 * Created by cyn on 04/01/2017.
 */

public class GoalDetailsActivity extends AppCompatActivity {

  private final static String TAG = "GoalDetailsActivity";
  @Inject
  GoalDetailsPresenter presenter;
  private SavingRuleAdapter rulesAdapter;
  private FeedElementAdapter feedAdapter;
  private GoalDetailsView view = new GoalDetailsView() {
    @Override
    public void fillUpFeed(List<FeedElement> feed) {
      feedAdapter.updateFeed(feed);
    }

    @Override
    public void fillUpSavingRules(List<SavingRule> rules) {
      rulesAdapter.updateItemListWithAnimation(rules);
    }

    @Override
    public void showErrorFeed() {
      Toast.makeText(GoalDetailsActivity.this, "Something went wrong while fetching the feed!",
          Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorRules() {
      Toast.makeText(GoalDetailsActivity.this, "Something went wrong while fetching the rules!",
          Toast.LENGTH_SHORT).show();
    }
  };

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_goal_details);

    //Get the extras
    final Goal goal = getIntent().getParcelableExtra("Goal");

    // RecyclerView feed
    RecyclerView feed = (RecyclerView) findViewById(R.id.feed);
    feed.setHasFixedSize(true);
    feed.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    // Add an item decorator to draw the dividers
    feed.addItemDecoration(new BaseItemDecoration(this, R.drawable.item_decorator));
    feedAdapter = new FeedElementAdapter(new LinkedList<FeedElement>());
    feed.setAdapter(feedAdapter);

    //RecyclerView rules
    RecyclerView rules = (RecyclerView) findViewById(R.id.saving_rules);
    rules.setHasFixedSize(true);
    rules.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    rulesAdapter = new SavingRuleAdapter(new LinkedList<SavingRule>(), R.layout.item_rule);
    rules.setAdapter(rulesAdapter);

    //HeaderImage
    ImageView imgHeader = (ImageView) findViewById(R.id.img_header);
    Picasso.with(this)
        .load(goal.getImageUrl())
        .placeholder(R.drawable.ic_image)
        .into(imgHeader);

    //Actionbar
    final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    setTitle(null);

    //GoalDetails
    TextView txtGoalName = (TextView) findViewById(R.id.txt_goal_name);
    txtGoalName.setText(goal.getName());
    TextView txtGoalProgress = (TextView) findViewById(R.id.txt_goal_progress);
    txtGoalProgress.setText(getString(R.string.progress_format, goal.getCurrentAmount(),
        goal.getTargetAmount()));
    ProgressBar goalProgress = (ProgressBar) findViewById(R.id.progress);
    goalProgress.setProgress(QapitalUtils.getProgress(goal.getCurrentAmount(),
        goal.getTargetAmount()));


    //Inject the presenter
    QapitalComponent component = (((QapitalApplication) getApplication())).getQapitalComponent();
    GoalDetailsComponent goalsComponent = component.plus(new GoalDetailsModule());
    presenter = goalsComponent.getGoalDetailsPresenter();
    presenter.setView(view);

    presenter.getFeed(goal.getId());
    presenter.getRules();
  }

  @Override
  protected void onStop() {
    super.onStop();
    presenter.onDestroy();
  }

  @Override
  protected void onDestroy() {
    presenter.onDestroy();
    super.onDestroy();
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    MenuInflater inflater = getMenuInflater();
    inflater.inflate(R.menu.goal_details_menu, menu);
    return true;
  }
}
