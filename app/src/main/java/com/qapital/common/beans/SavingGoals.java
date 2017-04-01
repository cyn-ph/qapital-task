package com.qapital.common.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cyn on 04/01/2017.
 */

public class SavingGoals {
  @SerializedName("savingsGoals")
  private List<Goal> goals;

  public List<Goal> getGoals() {
    return goals;
  }
}
