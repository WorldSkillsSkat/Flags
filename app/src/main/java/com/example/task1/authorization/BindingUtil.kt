package com.example.task1.authorization

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class BindingUtil() {
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
    }

}