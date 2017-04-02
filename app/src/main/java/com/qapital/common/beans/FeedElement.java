package com.qapital.common.beans;

import com.google.gson.annotations.SerializedName;
import com.qapital.R;
import com.qapital.utils.QapitalUtils;

import java.util.Date;

/**
 * Created by cyn on 04/01/2017.
 */

public class FeedElement {
  @SerializedName("id")
  private String id;
  @SerializedName("type")
  private String type;
  @SerializedName("timestamp")
  private Date datetime;
  @SerializedName("message")
  private String message;
  @SerializedName("amount")
  private float amount;
  @SerializedName("userId")
  private int userId;
  @SerializedName("savingsRuleId")
  private int savingRuleId;
  private int resId;

  public FeedElement() {
  }

  public FeedElement(Date datetime, String message, float amount) {
    this.datetime = datetime;
    this.message = message;
    this.amount = amount;
  }

  public String getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public String getDatetime() {
    return QapitalUtils.convertDateToRelativeText(datetime).toString();
  }

  public String getMessage() {

    return message;
  }

  public float getAmount() {
    return amount;
  }

  public int getUserId() {
    return userId;
  }

  public int getSavingRuleId() {
    return savingRuleId;
  }

  public int getResId() {
    return R.drawable.ic_default;
  }
}
