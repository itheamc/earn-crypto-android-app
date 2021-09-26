package com.itheamc.earncrypto.utils

import android.content.Context
import android.content.Intent

fun shareNow(context: Context?) {
    val intent = Intent(Intent.ACTION_SEND)
        .setType("text/plain")
        .putExtra(Intent.EXTRA_SUBJECT, "Let's start learning Jetpack Compose")
        .putExtra(
            Intent.EXTRA_TEXT,
            "Hey, Do you want to learn a new way of creating android app with Jetpack Compose? If yes then download this app --> https://play.google.com/store/apps/details?id=${context?.packageName}"
        )
    context?.startActivity(Intent.createChooser(intent, "Share Compose Basic With"))
}