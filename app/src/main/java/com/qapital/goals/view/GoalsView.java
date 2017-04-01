package com.qapital.goals.view;

import com.qapital.common.beans.Goal;
import com.qapital.common.view.BaseView;

import java.util.List;

/**
 * Created by cyn on 04/01/2017.
 */

public interface GoalsView extends BaseView {

  void showProgressBar();

  void hideProgressBar();

  void fillUpGoalsList(List<Goal> goals);

}
