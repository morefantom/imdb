package com.prathamesh.imdb.extensions

import android.widget.ImageView
import androidx.annotation.DrawableRes
import com.bumptech.glide.Glide

fun ImageView.load(@DrawableRes id: Int) {
    Glide.with(context).load(id).into(this)
}

fun ImageView.loadWithPlaceHolder(path: String, @DrawableRes placeholder: Int) {
    Glide.with(context).load(path).placeholder(placeholder).into(this)
}