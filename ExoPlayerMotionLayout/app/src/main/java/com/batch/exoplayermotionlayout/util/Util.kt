package com.pastel.lilac.clasick_android.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("android:imageUrl")
fun ImageView.loadImage(url: String?) {
    Glide.with(context)
        .load(url)
        .into(this)
}