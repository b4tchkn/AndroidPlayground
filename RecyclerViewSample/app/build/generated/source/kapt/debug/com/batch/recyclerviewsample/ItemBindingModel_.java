package com.batch.recyclerviewsample;

import android.view.View;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.databinding.ViewDataBinding;
import com.airbnb.epoxy.DataBindingEpoxyModel;
import com.airbnb.epoxy.EpoxyController;
import com.airbnb.epoxy.EpoxyModel;
import com.airbnb.epoxy.EpoxyViewHolder;
import com.airbnb.epoxy.GeneratedModel;
import com.airbnb.epoxy.OnModelBoundListener;
import com.airbnb.epoxy.OnModelClickListener;
import com.airbnb.epoxy.OnModelUnboundListener;
import com.airbnb.epoxy.OnModelVisibilityChangedListener;
import com.airbnb.epoxy.OnModelVisibilityStateChangedListener;
import com.airbnb.epoxy.WrappedEpoxyModelClickListener;
import com.batch.recyclerviewsample.model.Music;
import java.lang.CharSequence;
import java.lang.IllegalStateException;
import java.lang.Number;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;

/**
 * Generated file. Do not modify! */
public class ItemBindingModel_ extends DataBindingEpoxyModel implements GeneratedModel<DataBindingEpoxyModel.DataBindingHolder>, ItemBindingModelBuilder {
  private OnModelBoundListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> onModelBoundListener_epoxyGeneratedModel;

  private OnModelUnboundListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> onModelUnboundListener_epoxyGeneratedModel;

  private OnModelVisibilityStateChangedListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> onModelVisibilityStateChangedListener_epoxyGeneratedModel;

  private OnModelVisibilityChangedListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> onModelVisibilityChangedListener_epoxyGeneratedModel;

  private Music music;

  private View.OnClickListener itemClickListener;

  @Override
  public void addTo(EpoxyController controller) {
    super.addTo(controller);
    addWithDebugValidation(controller);
  }

  @Override
  public void handlePreBind(final EpoxyViewHolder holder,
      final DataBindingEpoxyModel.DataBindingHolder object, final int position) {
    validateStateHasNotChangedSinceAdded("The model was changed between being added to the controller and being bound.", position);
  }

  @Override
  public void handlePostBind(final DataBindingEpoxyModel.DataBindingHolder object, int position) {
    if (onModelBoundListener_epoxyGeneratedModel != null) {
      onModelBoundListener_epoxyGeneratedModel.onModelBound(this, object, position);
    }
    validateStateHasNotChangedSinceAdded("The model was changed during the bind call.", position);
  }

  /**
   * Register a listener that will be called when this model is bound to a view.
   * <p>
   * The listener will contribute to this model's hashCode state per the {@link
   * com.airbnb.epoxy.EpoxyAttribute.Option#DoNotHash} rules.
   * <p>
   * You may clear the listener by setting a null value, or by calling {@link #reset()} */
  public ItemBindingModel_ onBind(
      OnModelBoundListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener) {
    onMutation();
    this.onModelBoundListener_epoxyGeneratedModel = listener;
    return this;
  }

  @Override
  public void unbind(DataBindingEpoxyModel.DataBindingHolder object) {
    super.unbind(object);
    if (onModelUnboundListener_epoxyGeneratedModel != null) {
      onModelUnboundListener_epoxyGeneratedModel.onModelUnbound(this, object);
    }
  }

  /**
   * Register a listener that will be called when this model is unbound from a view.
   * <p>
   * The listener will contribute to this model's hashCode state per the {@link
   * com.airbnb.epoxy.EpoxyAttribute.Option#DoNotHash} rules.
   * <p>
   * You may clear the listener by setting a null value, or by calling {@link #reset()} */
  public ItemBindingModel_ onUnbind(
      OnModelUnboundListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener) {
    onMutation();
    this.onModelUnboundListener_epoxyGeneratedModel = listener;
    return this;
  }

  @Override
  public void onVisibilityStateChanged(int visibilityState,
      final DataBindingEpoxyModel.DataBindingHolder object) {
    if (onModelVisibilityStateChangedListener_epoxyGeneratedModel != null) {
      onModelVisibilityStateChangedListener_epoxyGeneratedModel.onVisibilityStateChanged(this, object, visibilityState);
    }
    super.onVisibilityStateChanged(visibilityState, object);
  }

  /**
   * Register a listener that will be called when this model visibility state has changed.
   * <p>
   * The listener will contribute to this model's hashCode state per the {@link
   * com.airbnb.epoxy.EpoxyAttribute.Option#DoNotHash} rules.
   */
  public ItemBindingModel_ onVisibilityStateChanged(
      OnModelVisibilityStateChangedListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener) {
    onMutation();
    this.onModelVisibilityStateChangedListener_epoxyGeneratedModel = listener;
    return this;
  }

  @Override
  public void onVisibilityChanged(float percentVisibleHeight, float percentVisibleWidth,
      int visibleHeight, int visibleWidth, final DataBindingEpoxyModel.DataBindingHolder object) {
    if (onModelVisibilityChangedListener_epoxyGeneratedModel != null) {
      onModelVisibilityChangedListener_epoxyGeneratedModel.onVisibilityChanged(this, object, percentVisibleHeight, percentVisibleWidth, visibleHeight, visibleWidth);
    }
    super.onVisibilityChanged(percentVisibleHeight, percentVisibleWidth, visibleHeight, visibleWidth, object);
  }

  /**
   * Register a listener that will be called when this model visibility has changed.
   * <p>
   * The listener will contribute to this model's hashCode state per the {@link
   * com.airbnb.epoxy.EpoxyAttribute.Option#DoNotHash} rules.
   */
  public ItemBindingModel_ onVisibilityChanged(
      OnModelVisibilityChangedListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> listener) {
    onMutation();
    this.onModelVisibilityChangedListener_epoxyGeneratedModel = listener;
    return this;
  }

  public ItemBindingModel_ music(Music music) {
    onMutation();
    this.music = music;
    return this;
  }

  public Music music() {
    return music;
  }

  /**
   * Set a click listener that will provide the parent view, model, and adapter position of the clicked view. This will clear the normal View.OnClickListener if one has been set */
  public ItemBindingModel_ itemClickListener(
      final OnModelClickListener<ItemBindingModel_, DataBindingEpoxyModel.DataBindingHolder> itemClickListener) {
    onMutation();
    if (itemClickListener == null) {
      this.itemClickListener = null;
    }
    else {
      this.itemClickListener = new WrappedEpoxyModelClickListener(itemClickListener);
    }
    return this;
  }

  public ItemBindingModel_ itemClickListener(View.OnClickListener itemClickListener) {
    onMutation();
    this.itemClickListener = itemClickListener;
    return this;
  }

  public View.OnClickListener itemClickListener() {
    return itemClickListener;
  }

  @Override
  public ItemBindingModel_ id(long id) {
    super.id(id);
    return this;
  }

  @Override
  public ItemBindingModel_ id(@Nullable Number... ids) {
    super.id(ids);
    return this;
  }

  @Override
  public ItemBindingModel_ id(long id1, long id2) {
    super.id(id1, id2);
    return this;
  }

  @Override
  public ItemBindingModel_ id(@Nullable CharSequence key) {
    super.id(key);
    return this;
  }

  @Override
  public ItemBindingModel_ id(@Nullable CharSequence key, @Nullable CharSequence... otherKeys) {
    super.id(key, otherKeys);
    return this;
  }

  @Override
  public ItemBindingModel_ id(@Nullable CharSequence key, long id) {
    super.id(key, id);
    return this;
  }

  @Override
  public ItemBindingModel_ layout(@LayoutRes int layoutRes) {
    super.layout(layoutRes);
    return this;
  }

  @Override
  public ItemBindingModel_ spanSizeOverride(
      @Nullable EpoxyModel.SpanSizeOverrideCallback spanSizeCallback) {
    super.spanSizeOverride(spanSizeCallback);
    return this;
  }

  @Override
  public ItemBindingModel_ show() {
    super.show();
    return this;
  }

  @Override
  public ItemBindingModel_ show(boolean show) {
    super.show(show);
    return this;
  }

  @Override
  public ItemBindingModel_ hide() {
    super.hide();
    return this;
  }

  @Override
  @LayoutRes
  protected int getDefaultLayout() {
    return R.layout.item;
  }

  @Override
  protected void setDataBindingVariables(ViewDataBinding binding) {
    if (!binding.setVariable(BR.music, music)) {
      throw new IllegalStateException("The attribute music was defined in your data binding model (com.airbnb.epoxy.DataBindingEpoxyModel) but a data variable of that name was not found in the layout.");
    }
    if (!binding.setVariable(BR.itemClickListener, itemClickListener)) {
      throw new IllegalStateException("The attribute itemClickListener was defined in your data binding model (com.airbnb.epoxy.DataBindingEpoxyModel) but a data variable of that name was not found in the layout.");
    }
  }

  @Override
  protected void setDataBindingVariables(ViewDataBinding binding, EpoxyModel previousModel) {
    if (!(previousModel instanceof ItemBindingModel_)) {
      setDataBindingVariables(binding);
      return;
    }
    ItemBindingModel_ that = (ItemBindingModel_) previousModel;
    if ((music != null ? !music.equals(that.music) : that.music != null)) {
      binding.setVariable(BR.music, music);
    }
    if (((itemClickListener == null) != (that.itemClickListener == null))) {
      binding.setVariable(BR.itemClickListener, itemClickListener);
    }
  }

  @Override
  public ItemBindingModel_ reset() {
    onModelBoundListener_epoxyGeneratedModel = null;
    onModelUnboundListener_epoxyGeneratedModel = null;
    onModelVisibilityStateChangedListener_epoxyGeneratedModel = null;
    onModelVisibilityChangedListener_epoxyGeneratedModel = null;
    this.music = null;
    this.itemClickListener = null;
    super.reset();
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (!(o instanceof ItemBindingModel_)) {
      return false;
    }
    if (!super.equals(o)) {
      return false;
    }
    ItemBindingModel_ that = (ItemBindingModel_) o;
    if (((onModelBoundListener_epoxyGeneratedModel == null) != (that.onModelBoundListener_epoxyGeneratedModel == null))) {
      return false;
    }
    if (((onModelUnboundListener_epoxyGeneratedModel == null) != (that.onModelUnboundListener_epoxyGeneratedModel == null))) {
      return false;
    }
    if (((onModelVisibilityStateChangedListener_epoxyGeneratedModel == null) != (that.onModelVisibilityStateChangedListener_epoxyGeneratedModel == null))) {
      return false;
    }
    if (((onModelVisibilityChangedListener_epoxyGeneratedModel == null) != (that.onModelVisibilityChangedListener_epoxyGeneratedModel == null))) {
      return false;
    }
    if ((music != null ? !music.equals(that.music) : that.music != null)) {
      return false;
    }
    if (((itemClickListener == null) != (that.itemClickListener == null))) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = super.hashCode();
    result = 31 * result + (onModelBoundListener_epoxyGeneratedModel != null ? 1 : 0);
    result = 31 * result + (onModelUnboundListener_epoxyGeneratedModel != null ? 1 : 0);
    result = 31 * result + (onModelVisibilityStateChangedListener_epoxyGeneratedModel != null ? 1 : 0);
    result = 31 * result + (onModelVisibilityChangedListener_epoxyGeneratedModel != null ? 1 : 0);
    result = 31 * result + (music != null ? music.hashCode() : 0);
    result = 31 * result + (itemClickListener != null ? 1 : 0);
    return result;
  }

  @Override
  public String toString() {
    return "ItemBindingModel_{" +
        "music=" + music +
        ", itemClickListener=" + itemClickListener +
        "}" + super.toString();
  }
}
