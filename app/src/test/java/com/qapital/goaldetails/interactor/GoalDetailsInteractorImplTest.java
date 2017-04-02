package com.qapital.goaldetails.interactor;

import com.qapital.common.api.QapitalAPI;
import com.qapital.common.beans.Feed;
import com.qapital.common.beans.SavingRules;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import io.reactivex.Observable;

import static org.mockito.Mockito.mock;

/**
 * Created by cyn on 04/02/2017.
 */
public class GoalDetailsInteractorImplTest {

  private QapitalAPI mockQapitalAPI;
  private GoalDetailsInteractor subject;

  @Before
  public void setUp() {
    mockQapitalAPI = mock(QapitalAPI.class);
    subject = new GoalDetailsInteractorImpl(mockQapitalAPI);
  }

  @Test
  public void fetchFeed() {
    final Observable<Feed> expectedResult = Mockito.mock(Observable.class);
    final int goalId = 1;
    Mockito.when(mockQapitalAPI.getFeed(goalId)).thenReturn(expectedResult);

    final Observable<Feed> realResult = subject.fetchFeed(goalId);
    Assert.assertEquals(expectedResult, realResult);
  }

  @Test
  public void fetchRules() {
    final Observable<SavingRules> expectedResult = Mockito.mock(Observable.class);
    Mockito.when(mockQapitalAPI.getSavingRules()).thenReturn(expectedResult);

    final Observable<SavingRules> realResult = subject.fetchRules();
    Mockito.verify(mockQapitalAPI).getSavingRules();
    Assert.assertEquals(expectedResult, realResult);
  }

}