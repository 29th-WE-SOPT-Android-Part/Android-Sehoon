package com.example.week1.feature.home

import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.databinding.BindingAdapter

object HomeBindingAdapter {
    @JvmStatic
    @BindingAdapter("imageResId")
    fun setImageResId(imageview: ImageView, @DrawableRes id: Int) {
        AppCompatResources.getDrawable(imageview.context, id).also {
            imageview.setImageDrawable(it)
        }
    }
}

class HomeAdapter {
    val homeList = mutableListOf<HomeData>()
}