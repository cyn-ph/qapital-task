package com.qapital.goaldetails.interactor;

import android.content.Context;

import javax.inject.Inject;

/**
 * Created by cyn on 04/01/2017.
 */

public class GoalDetailsInteractorImpl implements GoalDetailsInteractor {

  private Context context;

  @Inject
  public GoalDetailsInteractorImpl(Context context) {
    this.context = context;
  }

  @Override
  public void fetchFeed(int goalId) {

  }

  @Override
  public void fetchRules() {

  }
}
