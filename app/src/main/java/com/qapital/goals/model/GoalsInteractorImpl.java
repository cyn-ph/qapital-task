package com.qapital.goals.model;

import android.content.Context;

import com.qapital.common.api.QapitalAPI;
import com.qapital.common.beans.SavingGoals;

import javax.inject.Inject;

import io.reactivex.Observable;


/**
 * Created by cyn on 04/01/2017.
 */

public class GoalsInteractorImpl implements GoalsInteractor {

  Context context;
  QapitalAPI qapitalAPI;

  @Inject
  public GoalsInteractorImpl(Context context, QapitalAPI qapitalAPI) {
    this.context = context;
    this.qapitalAPI = qapitalAPI;
  }

  @Override
  public Observable<SavingGoals> fetchGoalsList() {
    return qapitalAPI.getGoalsList();
  }
}
