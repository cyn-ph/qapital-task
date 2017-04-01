package com.qapital.goaldetails.presenter;

import com.qapital.goaldetails.interactor.GoalDetailsInteractor;

import javax.inject.Inject;

/**
 * Created by cyn on 04/01/2017.
 */

public class GoalDetailsPresenterImpl extends GoalDetailsPresenter {

  GoalDetailsInteractor interactor;

  @Inject
  public GoalDetailsPresenterImpl(GoalDetailsInteractor interactor) {
    this.interactor = interactor;
  }

  @Override
  public void getFeed(int goalId) {
    interactor.fetchFeed(goalId);
  }

  @Override
  public void getRules() {
    interactor.fetchRules();
  }
}
