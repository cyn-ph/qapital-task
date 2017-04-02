package com.qapital.goals.presenter;

import com.qapital.common.beans.SavingGoals;
import com.qapital.goals.model.GoalsInteractor;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by cyn on 04/01/2017.
 */

public class GoalsPresenterImpl extends GoalsPresenter {

  private GoalsInteractor interactor;
  private Disposable disposable;

  @Inject
  public GoalsPresenterImpl(GoalsInteractor interactor) {
    this.interactor = interactor;
  }

  @Override
  public void getGoalsList() {
    getView().showProgressBar();
    final Observable<SavingGoals> savingGoalsObservable = interactor.fetchGoalsList();
    disposable = savingGoalsObservable.subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Consumer<SavingGoals>() {
          @Override
          public void accept(SavingGoals savingGoals) throws Exception {
            getView().fillUpGoalsList(savingGoals.getGoals());
            getView().hideProgressBar();
          }
        }, new Consumer<Throwable>() {
          @Override
          public void accept(Throwable throwable) throws Exception {
            getView().showError();
          }
        });
  }

  @Override
  public void onStop() {
    if (disposable != null) {
      disposable.dispose();
    }
  }
}
