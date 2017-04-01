package com.qapital.goaldetails.view;

import com.qapital.common.beans.FeedElement;
import com.qapital.common.beans.SavingRule;
import com.qapital.common.view.BaseView;

import java.util.List;

/**
 * Created by cyn on 04/01/2017.
 */

public interface GoalDetailsView extends BaseView {
  void fillUpFeed(List<FeedElement> feed);

  void fillUpSavingRules(List<SavingRule> rules);
}
