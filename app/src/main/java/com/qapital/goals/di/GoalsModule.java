package com.qapital.goals.di;

import com.qapital.di.ActivityScope;
import com.qapital.goals.model.GoalsInteractor;
import com.qapital.goals.model.GoalsInteractorImpl;
import com.qapital.goals.presenter.GoalsPresenter;
import com.qapital.goals.presenter.GoalsPresenterImpl;

import dagger.Module;
import dagger.Provides;

/**
 * Created by cyn on 04/01/2017.
 */
@Module
public class GoalsModule {
  @Provides
  @ActivityScope
  GoalsPresenter providesProfilePresenter(GoalsPresenterImpl presenter) {
    return presenter;
  }

  @Provides
  @ActivityScope
  GoalsInteractor providesGoalsInteractor(GoalsInteractorImpl interactor) {
    return interactor;
  }
}
