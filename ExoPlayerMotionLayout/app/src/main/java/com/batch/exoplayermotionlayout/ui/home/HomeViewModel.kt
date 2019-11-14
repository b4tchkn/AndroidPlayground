package com.batch.exoplayermotionlayout.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.batch.exoplayermotionlayout.model.Music

class HomeViewModel : ViewModel() {
    var musics = MutableLiveData<List<Music>>()
    private val musicListData = arrayListOf(
        Music("こんなに好きになっちゃっていいの？"),
        Music("ドレミソラシド"),
        Music("キュン"))
    fun fetch() {
        musics.value = musicListData
    }
}