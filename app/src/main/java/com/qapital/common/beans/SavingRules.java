package com.qapital.common.beans;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by cyn on 04/01/2017.
 */

public class SavingRules {
  @SerializedName("savingsRules")
  private List<SavingRule> savingRules;

  public List<SavingRule> getSavingRules() {
    return savingRules;
  }
}
