package com.qapital.goaldetails.di;

import com.qapital.di.ActivityScope;
import com.qapital.goaldetails.presenter.GoalDetailsPresenter;

import dagger.Subcomponent;

/**
 * Created by cyn on 04/01/2017.
 */
@ActivityScope
@Subcomponent(modules = {GoalDetailsModule.class})
public interface GoalDetailsComponent {
  GoalDetailsPresenter getGoalDetailsPresenter();
}
