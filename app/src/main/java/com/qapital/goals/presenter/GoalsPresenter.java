package com.qapital.goals.presenter;

import com.qapital.common.presenter.BasePresenter;
import com.qapital.goals.view.GoalsView;

/**
 * Created by cyn on 04/01/2017.
 */

public abstract class GoalsPresenter extends BasePresenter<GoalsView> {
  public abstract void getGoalsList();
}
