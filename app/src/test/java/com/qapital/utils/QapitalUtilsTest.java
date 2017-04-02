package com.qapital.utils;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by cyn on 04/02/2017.
 */
public class QapitalUtilsTest {

  @Test
  public void getProgress() throws Exception {
    // Config
    int expectedProgress = 11;
    float currentAmount = 500;
    final int total = 4500;
    // Execution
    int progress = QapitalUtils.getProgress(currentAmount, total);
    // Verification
    Assert.assertEquals(progress, expectedProgress);
  }

}