package com.qapital.common.beans;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.qapital.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by cyn on 03/31/2017.
 */

public class Goal {
  @SerializedName("goalImageURL")
  private String imageUrl;
  @SerializedName("userId")
  private int userId;
  @SerializedName("targetAmount")
  private float targetAmount;
  @SerializedName("currentBalance")
  private float currentAmount;
  @SerializedName("status")
  private String status;
  @SerializedName("name")
  private String name;
  @SerializedName("id")
  private int id;
  @SerializedName("connectedUsers")
  private List<Integer> connectedUsers;

  public Goal() {
  }

  public Goal(float targetAmount, float currentAmount, String name, String imageUrl) {
    this.targetAmount = targetAmount;
    this.currentAmount = currentAmount;
    this.name = name;
    this.imageUrl = imageUrl;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public int getUserId() {
    return userId;
  }

  public float getTargetAmount() {
    return targetAmount;
  }

  public float getCurrentAmount() {
    return currentAmount;
  }

  public String getStatus() {
    return status;
  }

  public String getName() {
    return name;
  }

  public int getId() {
    return id;
  }

  public List<Integer> getConnectedUsers() {
    return connectedUsers;
  }

  @BindingAdapter({"app:imageUrl"})
//  @BindingAdapter({"android:src"})
  public static void loadImage(ImageView view, String imageUrl) {
    Picasso.with(view.getContext())
        .load(imageUrl)
        .placeholder(R.drawable.ic_image)
        .into(view);
  }
}
