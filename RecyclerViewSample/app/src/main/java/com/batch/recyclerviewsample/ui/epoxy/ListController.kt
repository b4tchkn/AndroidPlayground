package com.batch.recyclerviewsample.ui.epoxy

import android.view.View
import com.airbnb.epoxy.TypedEpoxyController
import com.airbnb.epoxy.carousel
import com.batch.recyclerviewsample.headerView
import com.batch.recyclerviewsample.item
import com.batch.recyclerviewsample.model.Music

class ListController(private val callback: ClickListener) : TypedEpoxyController<List<Music>>() {
    interface ClickListener {
        fun itemClickListener(item: Music)
    }

    override fun buildModels(data: List<Music>) {
        headerView {
            id("header")
            title("タイトルだよ")
        }
        data.forEach { music ->
            item {
                id(0)
                music(music)
                itemClickListener(View.OnClickListener { callback.itemClickListener(music) })
            }
        }
//        carousel {
//            data.forEach { music ->
//                item {
//                    id(0)
//                    music(music)
//                }
//            }
//        }
    }
}