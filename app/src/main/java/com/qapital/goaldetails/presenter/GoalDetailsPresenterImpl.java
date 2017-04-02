package com.qapital.goaldetails.presenter;

import com.qapital.common.beans.Feed;
import com.qapital.common.beans.SavingRules;
import com.qapital.goaldetails.interactor.GoalDetailsInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by cyn on 04/01/2017.
 */

public class GoalDetailsPresenterImpl extends GoalDetailsPresenter {

  GoalDetailsInteractor interactor;
  private Disposable feedDisposable;
  private Disposable rulesDisposable;

  @Inject
  public GoalDetailsPresenterImpl(GoalDetailsInteractor interactor) {
    this.interactor = interactor;
  }

  @Override
  public void getFeed(int goalId) {
    final Observable<Feed> feedObservable = interactor.fetchFeed(goalId);
    feedDisposable = feedObservable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<Feed>() {
          @Override
          public void accept(Feed feed) throws Exception {
            getView().fillUpFeed(feed.getFeed());
          }
        }, new Consumer<Throwable>() {
          @Override
          public void accept(Throwable throwable) throws Exception {
            getView().showErrorFeed();
          }
        });

  }

  @Override
  public void getRules() {
    final Observable<SavingRules> savingRulesObservable = interactor.fetchRules();
    rulesDisposable = savingRulesObservable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<SavingRules>() {
          @Override
          public void accept(SavingRules savingRules) throws Exception {
            getView().fillUpSavingRules(savingRules.getSavingRules());
          }
        }, new Consumer<Throwable>() {
          @Override
          public void accept(Throwable throwable) throws Exception {
            getView().showErrorRules();
          }
        });
  }

  @Override
  public void onStop() {
    if (rulesDisposable != null) {
      rulesDisposable.dispose();
    }

    if (feedDisposable != null) {
      feedDisposable.dispose();
    }

  }
}
