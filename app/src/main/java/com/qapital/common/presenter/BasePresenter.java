package com.qapital.common.presenter;

import android.support.annotation.CallSuper;

import com.qapital.common.view.BaseView;

/**
 * Created by cyn on 03/30/2017.
 */

public class BasePresenter<T extends BaseView> {

  private T view;

  public void setView(T view) {
    this.view = view;
  }

  public T getView() {
    return view;
  }

  @CallSuper
  public void onDestroy() {
    view = null;
  }

}
