package com.qapital.common.beans;

import com.google.gson.annotations.SerializedName;

/**
 * Created by cyn on 04/01/2017.
 */

public class SavingRule {
  @SerializedName("id")
  private int id;
  @SerializedName("type")
  private String type;
  @SerializedName("amount")
  private float amount;

  public int getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public float getAmount() {
    return amount;
  }
}
