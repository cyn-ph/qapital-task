package com.qapital.goaldetails.interactor;

import com.qapital.common.api.QapitalAPI;
import com.qapital.common.beans.Feed;
import com.qapital.common.beans.SavingRules;

import javax.inject.Inject;

import io.reactivex.Observable;

/**
 * Created by cyn on 04/01/2017.
 */

public class GoalDetailsInteractorImpl implements GoalDetailsInteractor {

  private QapitalAPI qapitalAPI;

  @Inject
  public GoalDetailsInteractorImpl(QapitalAPI qapitalAPI) {
    this.qapitalAPI = qapitalAPI;
  }

  @Override
  public Observable<Feed> fetchFeed(int goalId) {
    return qapitalAPI.getFeed(goalId);
  }

  @Override
  public Observable<SavingRules> fetchRules() {
    return qapitalAPI.getSavingRules();
  }
}
