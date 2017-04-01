package com.qapital;

import android.app.Application;

import com.qapital.di.DaggerQapitalComponent;
import com.qapital.di.QapitalComponent;
import com.qapital.di.QapitalModule;

/**
 * Created by cyn on 04/01/2017.
 */

public class QapitalApplication extends Application {

  private QapitalComponent qapitalComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    // Dagger
    qapitalComponent = DaggerQapitalComponent
        .builder()
        .qapitalModule(new QapitalModule(this))
        .build();
  }

  public QapitalComponent getQapitalComponent() {
    return qapitalComponent;
  }
}
