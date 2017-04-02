package com.qapital.utils;

import android.databinding.BindingConversion;
import android.text.format.DateUtils;

import java.util.Date;

import static android.text.format.DateUtils.FORMAT_SHOW_YEAR;
import static android.text.format.DateUtils.SECOND_IN_MILLIS;

/**
 * Created by cyn on 04/01/2017.
 */

public class QapitalUtils {

  @BindingConversion
  public static CharSequence convertDateToRelativeText(Date date) {
    return DateUtils.getRelativeTimeSpanString(date.getTime(),
        new Date().getTime(), SECOND_IN_MILLIS, FORMAT_SHOW_YEAR);
  }

  public static int getProgress(float current, float total) {
    return (int) ((current * 100) / total);
  }
}
