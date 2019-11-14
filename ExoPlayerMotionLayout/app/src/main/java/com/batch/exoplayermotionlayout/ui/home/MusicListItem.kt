package com.batch.exoplayermotionlayout.ui.home

import com.batch.exoplayermotionlayout.R
import com.batch.exoplayermotionlayout.databinding.ItemMusicBinding
import com.batch.exoplayermotionlayout.model.Music
import com.xwray.groupie.databinding.BindableItem

class MusicListItem(private val musicList: Music) : BindableItem<ItemMusicBinding>() {
    override fun getLayout() = R.layout.item_music

    override fun bind(viewBinding: ItemMusicBinding, position: Int) {
        viewBinding.music = musicList
    }
}