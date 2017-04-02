package com.qapital.goals.model;

import com.qapital.common.api.QapitalAPI;
import com.qapital.common.beans.SavingGoals;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import io.reactivex.Observable;

import static org.mockito.Mockito.mock;

/**
 * Created by cyn on 04/02/2017.
 */
public class GoalsInteractorImplTest {

  private QapitalAPI mockQapitalAPI;
  private GoalsInteractor subject;

  @Before
  public void setUp() throws Exception {
    mockQapitalAPI = mock(QapitalAPI.class);
    subject = new GoalsInteractorImpl(mockQapitalAPI);
  }

  @Test
  public void fetchGoalsList() {
    final Observable<SavingGoals> expectedResult = Mockito.mock(Observable.class);
    Mockito.when(mockQapitalAPI.getGoalsList()).thenReturn(expectedResult);
    final Observable<SavingGoals> realResult = subject.fetchGoalsList();
    Mockito.verify(mockQapitalAPI).getGoalsList();
    Assert.assertEquals(expectedResult, realResult);
  }

}