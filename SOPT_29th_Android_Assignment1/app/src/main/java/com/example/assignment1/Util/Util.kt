package com.example.assignment1.Util

import android.content.Context
import android.widget.Toast

fun Context.shortToast(message : String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}