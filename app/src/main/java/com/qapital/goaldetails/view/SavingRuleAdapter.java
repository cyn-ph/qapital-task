package com.qapital.goaldetails.view;

import android.support.annotation.LayoutRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.qapital.R;
import com.qapital.common.beans.SavingRule;
import com.qapital.common.view.BaseRecyclerAdapter;

import java.util.List;

/**
 * Created by cyn on 04/01/2017.
 */

public class SavingRuleAdapter extends BaseRecyclerAdapter<SavingRuleAdapter.RuleViewHolder,
    SavingRule> {

  public SavingRuleAdapter(List<SavingRule> itemList, @LayoutRes int layout) {
    super(itemList, layout);
  }

  @Override
  protected RuleViewHolder createViewHolder(View convertView) {
    return new RuleViewHolder(convertView);
  }

  @Override
  protected void bindViewHolder(RuleViewHolder holder, SavingRule item) {
    int iconResource;
    switch (item.getId()) {
      case 1:
        iconResource = R.drawable.ic_round_up;
        break;
      case 2:
        iconResource = R.drawable.ic_guilty_pleasure;
        break;
      default:
        iconResource = R.drawable.ic_default;
        break;
    }
    holder.icon.setImageResource(iconResource);
  }

  class RuleViewHolder extends RecyclerView.ViewHolder {
    ImageView icon;

    public RuleViewHolder(View itemView) {
      super(itemView);
      icon = (ImageView) itemView.findViewById(R.id.icon_rule);
    }
  }

}
