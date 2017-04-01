package com.qapital.goaldetails.di;

import com.qapital.di.ActivityScope;
import com.qapital.goaldetails.interactor.GoalDetailsInteractor;
import com.qapital.goaldetails.interactor.GoalDetailsInteractorImpl;
import com.qapital.goaldetails.presenter.GoalDetailsPresenter;
import com.qapital.goaldetails.presenter.GoalDetailsPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cyn on 04/01/2017.
 */
@Module
public class GoalDetailsModule {
  @Provides
  @ActivityScope
  GoalDetailsPresenter providesGoalDetailsPresenter(GoalDetailsPresenterImpl presenter) {
    return presenter;
  }

  @Provides
  @ActivityScope
  GoalDetailsInteractor providesGoalDetailsInteractor(GoalDetailsInteractorImpl interactor) {
    return interactor;
  }
}
