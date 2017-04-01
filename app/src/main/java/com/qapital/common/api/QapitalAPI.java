package com.qapital.common.api;

import com.qapital.common.beans.SavingGoals;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by cyn on 04/01/2017.
 */

public interface QapitalAPI {
  @GET("savingsgoals")
  Call<SavingGoals> getGoalsList();
}
