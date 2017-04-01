package com.qapital.utils;

import android.databinding.BindingConversion;

import java.util.Date;

import static android.text.format.DateUtils.FORMAT_SHOW_YEAR;
import static android.text.format.DateUtils.SECOND_IN_MILLIS;
import static android.text.format.DateUtils.getRelativeTimeSpanString;

/**
 * Created by cyn on 04/01/2017.
 */

public class QapitalUtils {

  @BindingConversion
  public static CharSequence convertDateToRelativeText(Date date) {
    return getRelativeTimeSpanString(date.getTime(),
        new Date().getTime(), SECOND_IN_MILLIS, FORMAT_SHOW_YEAR);
  }
}