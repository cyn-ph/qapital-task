package com.qapital.goals.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qapital.common.beans.Goal;
import com.qapital.databinding.ItemGoalBinding;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cyn on 03/31/2017.
 */

public class GoalsAdapter extends RecyclerView.Adapter<GoalsAdapter.GoalViewHolder> {

  List<Goal> goals;
  GoalsListener goalsListener;

  public GoalsAdapter(List<Goal> goals, GoalsListener listener) {
    super();
    this.goals = goals;
    this.goalsListener = listener;
  }

  @Override
  public GoalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    ItemGoalBinding itemBinding = ItemGoalBinding.inflate(layoutInflater, parent, false);
    return new GoalViewHolder(itemBinding);
  }

  @Override
  public void onBindViewHolder(GoalViewHolder holder, int position) {
    Goal item = goals.get(position);
    holder.bind(item);
  }

  @Override
  public int getItemCount() {
    return goals.size();
  }

  public void updateGoals(List<Goal> newGoals) {
    this.goals = newGoals == null ? new LinkedList<Goal>() : newGoals;
    notifyDataSetChanged();
  }

  class GoalViewHolder extends RecyclerView.ViewHolder {
    private final ItemGoalBinding binding;

    public GoalViewHolder(ItemGoalBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    public void bind(Goal goal) {
      binding.setGoal(goal);
      binding.setListener(goalsListener);
      binding.executePendingBindings();
    }
  }

  public interface GoalsListener {
    void onGoalSelected(Goal goal);
  }
}
