package com.qapital.common.beans;

import android.databinding.BindingAdapter;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import com.google.gson.annotations.SerializedName;
import com.qapital.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by cyn on 03/31/2017.
 */

public class Goal implements Parcelable {
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

  protected Goal(Parcel in) {
    imageUrl = in.readString();
    userId = in.readInt();
    targetAmount = in.readFloat();
    currentAmount = in.readFloat();
    status = in.readString();
    name = in.readString();
    id = in.readInt();
  }

  public static final Creator<Goal> CREATOR = new Creator<Goal>() {
    @Override
    public Goal createFromParcel(Parcel in) {
      return new Goal(in);
    }

    @Override
    public Goal[] newArray(int size) {
      return new Goal[size];
    }
  };

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
  public static void loadImage(ImageView view, String imageUrl) {
    Picasso.with(view.getContext())
        .load(imageUrl)
        .placeholder(R.drawable.ic_image)
        .into(view);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel parcel, int i) {
    parcel.writeString(imageUrl);
    parcel.writeInt(userId);
    parcel.writeFloat(targetAmount);
    parcel.writeFloat(currentAmount);
    parcel.writeString(status);
    parcel.writeString(name);
    parcel.writeInt(id);
  }
}
