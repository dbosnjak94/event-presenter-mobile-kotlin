package com.example.mobile_app_dev_project.util

import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.NavHost
import com.bumptech.glide.Glide

fun AppCompatActivity.findNavControllerWorkaround(resId: Int): NavController {
    return (supportFragmentManager.findFragmentById(resId) as NavHost).navController
}

fun ImageView.loadUrl(url: String?) {
    url?.let {
        Glide.with(this).load(it).into(this)
    }
}