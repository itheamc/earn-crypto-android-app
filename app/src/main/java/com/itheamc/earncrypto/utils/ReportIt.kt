package com.itheamc.earncrypto.utils

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import androidx.core.content.ContextCompat.startActivity


// val body = Html.fromHtml(fragment.resources.getString(R.string.email_body))
fun reportBugs(context: Context?) {
    val intent =
        Intent(Intent.ACTION_SENDTO, Uri.fromParts("mailto", "support@amcbizprojects.co.in", null))
    intent.putExtra(Intent.EXTRA_SUBJECT, "Bugs related to - ")
    context?.startActivity(Intent.createChooser(intent, "Contact Us With"))
}