package com.example.user.garbarinotest.utils

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(context).inflate(layoutRes, this)
}

fun Activity.createNewView(layoutRes: Int, parent:ViewGroup? = null): View {
    return LayoutInflater.from(this).inflate(layoutRes, parent)
}