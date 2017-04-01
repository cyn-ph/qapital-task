package com.qapital.common.api;

import com.qapital.common.beans.Feed;
import com.qapital.common.beans.SavingGoals;
import com.qapital.common.beans.SavingRules;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;


/**
 * Created by cyn on 04/01/2017.
 */

public interface QapitalAPI {
  @GET("savingsgoals")
  Observable<SavingGoals> getGoalsList();

  @GET("savingsrules")
  Observable<SavingRules> getSavingRules();

  @GET("savingsgoals/{id}/feed")
  Observable<Feed> getFeed(@Path("id") int groupId);
}
