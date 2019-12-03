package com.batch.recyclerviewsample.ui.epoxy;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/batch/recyclerviewsample/ui/epoxy/ListController;", "Lcom/airbnb/epoxy/TypedEpoxyController;", "", "Lcom/batch/recyclerviewsample/model/Music;", "callback", "Lcom/batch/recyclerviewsample/ui/epoxy/ListController$ClickListener;", "(Lcom/batch/recyclerviewsample/ui/epoxy/ListController$ClickListener;)V", "buildModels", "", "data", "ClickListener", "app_debug"})
public final class ListController extends com.airbnb.epoxy.TypedEpoxyController<java.util.List<? extends com.batch.recyclerviewsample.model.Music>> {
    private final com.batch.recyclerviewsample.ui.epoxy.ListController.ClickListener callback = null;
    
    @java.lang.Override()
    protected void buildModels(@org.jetbrains.annotations.NotNull()
    java.util.List<com.batch.recyclerviewsample.model.Music> data) {
    }
    
    public ListController(@org.jetbrains.annotations.NotNull()
    com.batch.recyclerviewsample.ui.epoxy.ListController.ClickListener callback) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/batch/recyclerviewsample/ui/epoxy/ListController$ClickListener;", "", "itemClickListener", "", "item", "Lcom/batch/recyclerviewsample/model/Music;", "app_debug"})
    public static abstract interface ClickListener {
        
        public abstract void itemClickListener(@org.jetbrains.annotations.NotNull()
        com.batch.recyclerviewsample.model.Music item);
    }
}