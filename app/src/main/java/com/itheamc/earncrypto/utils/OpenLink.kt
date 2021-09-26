package com.itheamc.earncrypto.utils

import android.content.Context
import android.content.Intent
import android.net.Uri

fun openLink(context: Context?, link: String) {
    val uri = Uri.parse(link)
    val intent = Intent(Intent.ACTION_VIEW, uri)
    context?.startActivity(intent)
}