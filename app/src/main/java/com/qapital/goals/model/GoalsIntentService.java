package com.qapital.goals.model;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.qapital.QapitalApplication;
import com.qapital.common.api.QapitalAPI;

import javax.inject.Inject;

/**
 * Created by cyn on 04/01/2017.
 */

public class GoalsIntentService extends IntentService {

  final static private String TAG = "GoalsIntentService";
  @Inject
  QapitalAPI qapitalAPI;

  public GoalsIntentService() {
    super("GoalsIntentService");
  }

  @Override
  public void onCreate() {
    super.onCreate();
    ((QapitalApplication) getApplication()).getQapitalComponent().inject(this);
  }

  @Override
  protected void onHandleIntent(@Nullable Intent intent) {
//    Log.d(TAG, "onHandleIntent: ");
//    try {
//      final Response<SavingGoals> response = qapitalAPI.getGoalsList().execute();
//      if (response.isSuccessful()) {
//        final SavingGoals savingGoals = response.body();
//        Log.d(TAG, "fetchGoalsList: " + savingGoals.getGoals().size());
//      } else {
//        Log.d(TAG, "onHandleIntent: call failed ");
//      }
//    } catch (IOException e) {
//      Log.e(TAG, "onHandleIntent: ", e);
//    }
  }
}
