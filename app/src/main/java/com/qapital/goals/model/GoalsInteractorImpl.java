package com.qapital.goals.model;

import android.content.Context;
import android.content.Intent;

import javax.inject.Inject;

/**
 * Created by cyn on 04/01/2017.
 */

public class GoalsInteractorImpl implements GoalsInteractor {

  Context context;

  @Inject
  public GoalsInteractorImpl(Context context) {
    this.context = context;
  }

  @Override
  public void fetchGoalsList() {
    Intent intentService = new Intent(context, GoalsIntentService.class);
    context.startService(intentService);
  }
}
