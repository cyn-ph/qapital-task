package com.qapital.goals.model;

import com.qapital.common.beans.SavingGoals;

import io.reactivex.Observable;


/**
 * Created by cyn on 04/01/2017.
 */

public interface GoalsInteractor {
  Observable<SavingGoals> fetchGoalsList();
}
