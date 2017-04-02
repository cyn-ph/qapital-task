package com.qapital.goaldetails.interactor;

import com.qapital.common.beans.Feed;
import com.qapital.common.beans.SavingRules;

import io.reactivex.Observable;

/**
 * Created by cyn on 04/01/2017.
 */

public interface GoalDetailsInteractor {
  Observable<Feed> fetchFeed(int goalId);

  Observable<SavingRules> fetchRules();
}
