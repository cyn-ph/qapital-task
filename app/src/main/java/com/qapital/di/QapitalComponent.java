package com.qapital.di;

import com.qapital.goaldetails.di.GoalDetailsComponent;
import com.qapital.goaldetails.di.GoalDetailsModule;
import com.qapital.goals.di.GoalsComponent;
import com.qapital.goals.di.GoalsModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by cyn on 04/01/2017.
 */
@Singleton
@Component(modules = {QapitalModule.class})
public interface QapitalComponent {
  GoalsComponent plus(GoalsModule module);

  GoalDetailsComponent plus(GoalDetailsModule module);
}
