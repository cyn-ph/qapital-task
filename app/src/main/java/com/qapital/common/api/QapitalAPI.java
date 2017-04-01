package com.qapital.common.api;

import com.qapital.common.beans.Feed;
import com.qapital.common.beans.SavingGoals;
import com.qapital.common.beans.SavingRules;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by cyn on 04/01/2017.
 */

public interface QapitalAPI {
  @GET("savingsgoals")
  Call<SavingGoals> getGoalsList();

  @GET("savingsrules")
  Call<SavingRules> getSavingRules();

  @GET("savingsgoals/{id}/feed")
  Call<Feed> getFeed(@Path("id") int groupId);
}
