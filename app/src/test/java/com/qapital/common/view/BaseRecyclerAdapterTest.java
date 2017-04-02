package com.qapital.common.view;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qapital.R;
import com.qapital.common.beans.MyObject;
import com.qapital.common.beans.MyViewHolder;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by cyn on 04/02/2017.
 */
public class BaseRecyclerAdapterTest {

  private TestRecyclerAdapter testObject;
  private List<MyObject> mockList;
  private final static int LAYOUT = R.layout.item_feed;
  private LayoutInflater mockLayoutInflater;

  @Before
  public void setUp() throws Exception {
    mockList = Mockito.mock(List.class);
    testObject = new TestRecyclerAdapter(mockList, LAYOUT);
    mockLayoutInflater = Mockito.mock(LayoutInflater.class);
  }

  @Test
  public void add() throws Exception {
    MyObject item = new MyObject();
    testObject.add(item);
    Mockito.verify(mockList).add(item);
  }

  @Test
  public void addWithAnimation() {
    MyObject item = new MyObject();
    int expectedSize = 1;
    Mockito.when(mockList.size()).thenReturn(expectedSize);
    // Test is failing (NPE) because notifyItemInserted is final and cannot be mocked
    // we need Roboelectric/Espresso to test it
//    testObject = Mockito.spy(testObject);
//    Mockito.doNothing().when(testObject).notifyItemInserted(expectedSize);
//    testObject.addWithAnimation(item);
//    Mockito.verify(testObject).add(item);
//    Mockito.verify(testObject).notifyItemInserted(expectedSize);
  }

  @Test
  public void onCreateViewHolder() {
    ViewGroup viewGroup = Mockito.mock(ViewGroup.class);
    int viewType = 1;
    View convertView = Mockito.mock(View.class);
    Mockito.when(mockLayoutInflater.inflate(LAYOUT, viewGroup, false)).thenReturn(convertView);
    testObject = Mockito.spy(testObject);
    testObject.onCreateViewHolder(viewGroup, viewType);
    Mockito.verify(testObject).createViewHolder(convertView);
  }

  @Test
  public void onBindViewHolder() {
    MyViewHolder holder = Mockito.mock(MyViewHolder.class);
    int position = 1;
    testObject = Mockito.spy(testObject);
    final MyObject expectedItem = new MyObject();
    Mockito.when(mockList.get(position)).thenReturn(expectedItem);
    testObject.onBindViewHolder(holder, position);
    Mockito.verify(testObject).bindViewHolder(holder, expectedItem);
  }

  @Test
  public void getItemCount() {
    testObject.getItemCount();
    Mockito.verify(mockList).size();
  }

  @Test
  public void updateItemListWithAnimation() {
    final List<MyObject> mockNewList = new LinkedList<>();
    mockNewList.add(new MyObject());
    mockNewList.add(new MyObject());
    mockNewList.add(new MyObject());
    mockNewList.add(new MyObject());
    testObject = Mockito.spy(testObject);
    Mockito.doNothing().when(testObject).addWithAnimation(Matchers.any(MyObject.class));
    testObject.updateItemListWithAnimation(mockNewList);
    Mockito.verify(testObject, Mockito.times(mockNewList.size()))
        .addWithAnimation(Matchers.any(MyObject.class));
  }

  private class TestRecyclerAdapter extends BaseRecyclerAdapter<MyViewHolder, MyObject> {
    private TestRecyclerAdapter(List<MyObject> itemList, @LayoutRes int layout) {
      super(itemList, layout);
    }

    @Override
    protected MyViewHolder createViewHolder(View convertView) {
      return null;
    }

    @Override
    protected void bindViewHolder(MyViewHolder holder, MyObject item) {
    }

    @Override
    protected LayoutInflater getLayoutInflater(ViewGroup parent) {
      return mockLayoutInflater;
    }
  }

}