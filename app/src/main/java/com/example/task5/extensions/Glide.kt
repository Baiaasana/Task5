package com.example.task5.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.example.task5.R

class Glide {

    fun setImage(url: String, image: ImageView){
        Glide
            .with(image.context)
            .load(url)
            .placeholder(R.mipmap.place_holder)
            .centerCrop()
            .into(image)
    }
}