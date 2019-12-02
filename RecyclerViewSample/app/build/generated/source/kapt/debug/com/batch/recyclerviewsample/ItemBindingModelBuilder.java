package com.batch.recyclerviewsample;

import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import com.airbnb.epoxy.DataBindingEpoxyModel;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.OnModelBoundListener;
import com.airbnb.epoxy.OnModelClickListener;
import com.airbnb.epoxy.OnModelUnboundListener;
import com.airbnb.epoxy.OnModelVisibilityChangedListener;
import com.airbnb.epoxy.OnModelVisibilityStateChangedListener;
import com.batch.recyclerviewsample.model.Music;
import java.lang.CharSequence;
import java.lang.Number;

public interface ItemBindingModelBuilder {
  ItemBindingModelBuilder onBind(
      OnModelBoundListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  ItemBindingModelBuilder onUnbind(
      OnModelUnboundListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  ItemBindingModelBuilder onVisibilityStateChanged(
      OnModelVisibilityStateChangedListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  ItemBindingModelBuilder onVisibilityChanged(
      OnModelVisibilityChangedListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener);

  ItemBindingModelBuilder music(Music music);

  ItemBindingModelBuilder itemClickListener(
      final OnModelClickListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> itemClickListener);

  ItemBindingModelBuilder itemClickListener(View.OnClickListener itemClickListener);

  ItemBindingModelBuilder id(long id);

  ItemBindingModelBuilder id(@Nullable Number... ids);

  ItemBindingModelBuilder id(long id1, long id2);

  ItemBindingModelBuilder id(@Nullable CharSequence key);

  ItemBindingModelBuilder id(@Nullable CharSequence key, @Nullable CharSequence... otherKeys);

  ItemBindingModelBuilder id(@Nullable CharSequence key, long id);

  ItemBindingModelBuilder layout(@LayoutRes int layoutRes);

  ItemBindingModelBuilder spanSizeOverride(
      @Nullable EpoxyModel.SpanSizeOverrideCallback spanSizeCallback);
}
