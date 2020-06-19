package com.batch.recyclerviewsample.ui.groupie

import com.batch.recyclerviewsample.R
import com.batch.recyclerviewsample.databinding.ItemBinding
import com.batch.recyclerviewsample.model.Music
import com.xwray.groupie.databinding.BindableItem
import timber.log.Timber

class ListItem(private val musicList: Music) : BindableItem<ItemBinding>() {

    override fun getLayout() = R.layout.item

    override fun bind(viewBinding: ItemBinding, position: Int) {
        viewBinding.music = musicList

        viewBinding.setItemClickListener {
            val tappedMusic = musicList
            Timber.d(tappedMusic.toString())
            Timber.d(position.toString())
        }
    }
}