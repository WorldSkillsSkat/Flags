package com.example.task1

import android.annotation.SuppressLint
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, url: String) {
        Glide.with(view.context).load(url).into(view)
}

@SuppressLint("SetTextI18n")
@BindingAdapter("setTextView")
fun setPopulation(view: TextView, population: Int) {
        view.text = "Популяция: $population"
}
