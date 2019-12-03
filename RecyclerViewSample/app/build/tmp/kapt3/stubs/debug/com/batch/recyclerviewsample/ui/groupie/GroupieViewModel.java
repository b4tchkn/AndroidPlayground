package com.batch.recyclerviewsample.ui.groupie;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000f\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"Lcom/batch/recyclerviewsample/ui/groupie/GroupieViewModel;", "Landroidx/lifecycle/AndroidViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "api", "Lcom/batch/recyclerviewsample/SampleRepository;", "musics", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/batch/recyclerviewsample/model/Music;", "getMusics", "()Landroidx/lifecycle/MutableLiveData;", "setMusics", "(Landroidx/lifecycle/MutableLiveData;)V", "fetchRemote", "", "app_debug"})
public final class GroupieViewModel extends androidx.lifecycle.AndroidViewModel {
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.batch.recyclerviewsample.model.Music>> musics;
    private final com.batch.recyclerviewsample.SampleRepository api = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.batch.recyclerviewsample.model.Music>> getMusics() {
        return null;
    }
    
    public final void setMusics(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.batch.recyclerviewsample.model.Music>> p0) {
    }
    
    public final void fetchRemote() {
    }
    
    public GroupieViewModel(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        super(null);
    }
}