package com.example.proiectbun.extensiihelper

import android.util.Log

fun String.logErrorMessage(tag: String = "  Aplicatie ") {
    Log.e(tag, this)
}