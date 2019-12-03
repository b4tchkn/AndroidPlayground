package com.batch.recyclerviewsample.databinding;
import com.batch.recyclerviewsample.R;
import com.batch.recyclerviewsample.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemBindingImpl extends ItemBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 4, sIncludes, sViewsWithIds));
    }
    private ItemBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[3]
            , (android.widget.LinearLayout) bindings[0]
            , (android.widget.TextView) bindings[2]
            );
        this.coverImageView.setTag(null);
        this.descriptionTextView.setTag(null);
        this.musicItem.setTag(null);
        this.musicNameTextView.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.itemClickListener == variableId) {
            setItemClickListener((android.view.View.OnClickListener) variable);
        }
        else if (BR.music == variableId) {
            setMusic((com.batch.recyclerviewsample.model.Music) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItemClickListener(@Nullable android.view.View.OnClickListener ItemClickListener) {
        this.mItemClickListener = ItemClickListener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.itemClickListener);
        super.requestRebind();
    }
    public void setMusic(@Nullable com.batch.recyclerviewsample.model.Music Music) {
        this.mMusic = Music;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.music);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String musicName = null;
        java.lang.String musicDescription = null;
        android.view.View.OnClickListener itemClickListener = mItemClickListener;
        com.batch.recyclerviewsample.model.Music music = mMusic;
        java.lang.String musicCoverPath = null;

        if ((dirtyFlags & 0x5L) != 0) {
        }
        if ((dirtyFlags & 0x6L) != 0) {



                if (music != null) {
                    // read music.name
                    musicName = music.getName();
                    // read music.description
                    musicDescription = music.getDescription();
                    // read music.coverPath
                    musicCoverPath = music.getCoverPath();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x6L) != 0) {
            // api target 1

            com.batch.recyclerviewsample.util.UtilKt.loadImage(this.coverImageView, musicCoverPath);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.descriptionTextView, musicDescription);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.musicNameTextView, musicName);
        }
        if ((dirtyFlags & 0x5L) != 0) {
            // api target 1

            this.musicItem.setOnClickListener(itemClickListener);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): itemClickListener
        flag 1 (0x2L): music
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}