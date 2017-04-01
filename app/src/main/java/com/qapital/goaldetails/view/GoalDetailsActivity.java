package com.qapital.goaldetails.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

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

import java.util.Date;
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
  GoalDetailsView view = new GoalDetailsView() {
    @Override
    public void fillUpFeed(List<FeedElement> feed) {
      feedAdapter.updateFeed(feed);
    }

    @Override
    public void fillUpSavingRules(List<SavingRule> rules) {
      rulesAdapter.updateItemListWithAnimation(rules);
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

    // TODO: 04/01/2017 remove
    List<FeedElement> feedElements = new LinkedList<>();
    feedElements.add(new FeedElement(new Date(), "made a round up", 10));
    feedElements.add(new FeedElement(new Date(), "made a round up", 20));
    feedElements.add(new FeedElement(new Date(), "made a round up", 30));
    feedElements.add(new FeedElement(new Date(), "made a round up", 40));
    feedElements.add(new FeedElement(new Date(), "made a round up", 50));
    feedElements.add(new FeedElement(new Date(), "made a round up", 60));
    feedAdapter = new FeedElementAdapter(feedElements);
    feed.setAdapter(feedAdapter);

    //RecyclerView rules
    RecyclerView rules = (RecyclerView) findViewById(R.id.saving_rules);
    feed.setHasFixedSize(true);
    feed.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    rulesAdapter = new SavingRuleAdapter(new LinkedList<SavingRule>(), R.layout.item_rule);
    feed.setAdapter(rulesAdapter);

    //Inject the presenter
    QapitalComponent component = (((QapitalApplication) getApplication())).getQapitalComponent();
    GoalDetailsComponent goalsComponent = component.plus(new GoalDetailsModule());
    presenter = goalsComponent.getGoalDetailsPresenter();
    presenter.setView(view);

    presenter.getFeed(goal.getId());
    presenter.getRules();
  }
}
