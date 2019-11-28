package com.batch.recyclerviewsample.ui.epoxy

import android.view.View
import com.airbnb.epoxy.TypedEpoxyController
import com.batch.recyclerviewsample.item
import com.batch.recyclerviewsample.model.Music

class ListController(private val callback: ClickListener) : TypedEpoxyController<List<Music>>() {
    interface ClickListener {
        fun itemClickListener(item: Music)
    }

    override fun buildModels(data: List<Music>) {
        data.forEach { music ->
            item {
                id(0)
                music(music)
                itemClickListener(View.OnClickListener { callback.itemClickListener(music) })
            }
        }
    }
}