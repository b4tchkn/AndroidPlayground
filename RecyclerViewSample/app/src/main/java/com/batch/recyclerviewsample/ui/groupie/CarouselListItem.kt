package com.batch.recyclerviewsample.ui.groupie

import androidx.recyclerview.widget.LinearLayoutManager
import com.batch.recyclerviewsample.R
import com.batch.recyclerviewsample.databinding.MyCarouselLayoutBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.databinding.BindableItem

class CarouselListItem(private val carouselAdapter: GroupAdapter<GroupieViewHolder>) :
    BindableItem<MyCarouselLayoutBinding>() {
    override fun getLayout(): Int = R.layout.my_carousel_layout

    override fun bind(viewBinding: MyCarouselLayoutBinding, position: Int) {
        viewBinding.recyclerCarousel.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            adapter = carouselAdapter
        }
    }

    override fun getId(): Long  = id
}