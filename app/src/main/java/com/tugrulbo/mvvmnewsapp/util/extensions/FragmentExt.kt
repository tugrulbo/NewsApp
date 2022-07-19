package com.tugrulbo.mvvmnewsapp.util.extensions

import android.widget.Toast
import androidx.fragment.app.Fragment

fun Fragment.showMessage(msg:String){
    Toast.makeText(requireContext(), msg, Toast.LENGTH_SHORT).show()
}