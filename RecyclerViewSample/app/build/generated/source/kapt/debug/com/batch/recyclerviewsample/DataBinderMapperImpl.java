package com.batch.recyclerviewsample;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.batch.recyclerviewsample.databinding.FragmentGroupieBindingImpl;
import com.batch.recyclerviewsample.databinding.HeaderViewBindingImpl;
import com.batch.recyclerviewsample.databinding.ItemBindingImpl;
import com.batch.recyclerviewsample.databinding.MyCarouselLayoutBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_FRAGMENTGROUPIE = 1;

  private static final int LAYOUT_HEADERVIEW = 2;

  private static final int LAYOUT_ITEM = 3;

  private static final int LAYOUT_MYCAROUSELLAYOUT = 4;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(4);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.batch.recyclerviewsample.R.layout.fragment_groupie, LAYOUT_FRAGMENTGROUPIE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.batch.recyclerviewsample.R.layout.header_view, LAYOUT_HEADERVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.batch.recyclerviewsample.R.layout.item, LAYOUT_ITEM);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.batch.recyclerviewsample.R.layout.my_carousel_layout, LAYOUT_MYCAROUSELLAYOUT);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_FRAGMENTGROUPIE: {
          if ("layout/fragment_groupie_0".equals(tag)) {
            return new FragmentGroupieBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_groupie is invalid. Received: " + tag);
        }
        case  LAYOUT_HEADERVIEW: {
          if ("layout/header_view_0".equals(tag)) {
            return new HeaderViewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for header_view is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEM: {
          if ("layout/item_0".equals(tag)) {
            return new ItemBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item is invalid. Received: " + tag);
        }
        case  LAYOUT_MYCAROUSELLAYOUT: {
          if ("layout/my_carousel_layout_0".equals(tag)) {
            return new MyCarouselLayoutBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for my_carousel_layout is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(2);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    result.add(new com.airbnb.epoxy.databinding.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(4);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "itemClickListener");
      sKeys.put(2, "music");
      sKeys.put(3, "title");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(4);

    static {
      sKeys.put("layout/fragment_groupie_0", com.batch.recyclerviewsample.R.layout.fragment_groupie);
      sKeys.put("layout/header_view_0", com.batch.recyclerviewsample.R.layout.header_view);
      sKeys.put("layout/item_0", com.batch.recyclerviewsample.R.layout.item);
      sKeys.put("layout/my_carousel_layout_0", com.batch.recyclerviewsample.R.layout.my_carousel_layout);
    }
  }
}
