package com.qapital.goals.di;

import com.qapital.di.ActivityScope;
import com.qapital.goals.presenter.GoalsPresenter;

import dagger.Subcomponent;

/**
 * Created by cyn on 04/01/2017.
 */
@ActivityScope
@Subcomponent(modules = {GoalsModule.class})
public interface GoalsComponent {
  GoalsPresenter getGoalsPresenter();
}
