package com.qapital.di;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.qapital.common.api.QapitalAPI;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by cyn on 04/01/2017.
 */
@Module
public class QapitalModule {

  private Context context;

  public QapitalModule(Context context) {
    this.context = context;
  }

  @Provides
  @Singleton
  Context provideContext() {
    return context;
  }

  @Provides
  @Singleton
  Gson provideGson() {
    return new GsonBuilder().setPrettyPrinting().create();
  }

  @Provides
  @Singleton
  QapitalAPI providesAliadaAPI() {

    Retrofit retrofit = new Retrofit.Builder()
        .baseUrl("http://qapital-ios-testtask.herokuapp.com")
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build();

    return retrofit.create(QapitalAPI.class);
  }

}
