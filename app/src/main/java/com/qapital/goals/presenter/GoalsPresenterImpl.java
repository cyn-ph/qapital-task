package com.qapital.goals.presenter;

import com.qapital.goals.model.GoalsInteractor;

import javax.inject.Inject;

/**
 * Created by cyn on 04/01/2017.
 */

public class GoalsPresenterImpl extends GoalsPresenter {

  GoalsInteractor interactor;

  @Inject
  public GoalsPresenterImpl(GoalsInteractor interactor) {
    this.interactor = interactor;
  }

  @Override
  public void getGoalsList() {
    getView().showProgressBar();
    interactor.fetchGoalsList();
  }
}
