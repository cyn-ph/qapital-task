package com.qapital.goaldetails.presenter;

import com.qapital.common.presenter.BasePresenter;
import com.qapital.goaldetails.view.GoalDetailsView;

/**
 * Created by cyn on 04/01/2017.
 */

public abstract class GoalDetailsPresenter extends BasePresenter<GoalDetailsView> {

  public abstract void getFeed(int goalId);

  public abstract void getRules();

  public abstract void onStop();

}
