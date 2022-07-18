package com.tugrulbo.mvvmnewsapp.util.extensions

import android.view.View

fun View.isVisible(isVisible:Boolean){
    if (isVisible){
        View.VISIBLE
    }else{
        View.GONE
    }
}