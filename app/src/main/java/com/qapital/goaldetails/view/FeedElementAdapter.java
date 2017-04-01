package com.qapital.goaldetails.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.qapital.common.beans.FeedElement;
import com.qapital.databinding.ItemFeedBinding;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cyn on 04/01/2017.
 */

public class FeedElementAdapter extends
    RecyclerView.Adapter<FeedElementAdapter.FeedElementViewHolder> {

  List<FeedElement> feed;

  public FeedElementAdapter(List<FeedElement> feed) {
    this.feed = feed;
  }

  @Override
  public FeedElementViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    ItemFeedBinding itemBinding = ItemFeedBinding.inflate(layoutInflater, parent, false);
    return new FeedElementViewHolder(itemBinding);
  }

  @Override
  public void onBindViewHolder(FeedElementViewHolder holder, int position) {
    FeedElement item = feed.get(position);
    holder.bind(item);
  }

  public void updateFeed(List<FeedElement> newFeed) {
    this.feed = (newFeed == null ? new LinkedList<FeedElement>() : newFeed);
    notifyDataSetChanged();
  }

  @Override
  public int getItemCount() {
    return feed.size();
  }

  class FeedElementViewHolder extends RecyclerView.ViewHolder {
    private final ItemFeedBinding binding;

    public FeedElementViewHolder(ItemFeedBinding binding) {
      super(binding.getRoot());
      this.binding = binding;
    }

    public void bind(FeedElement feedElement) {
      binding.setFeedElement(feedElement);
      binding.executePendingBindings();
    }
  }
}
