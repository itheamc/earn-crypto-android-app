package com.itheamc.earncrypto.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast


fun rateNow(context: Context?) {
    try {
        val uri = Uri.parse("market://details?id=${context?.packageName}")
        val intent = Intent(Intent.ACTION_VIEW, uri)
        context?.startActivity(intent)
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "Play store not found!!", Toast.LENGTH_SHORT).show()
    }
}