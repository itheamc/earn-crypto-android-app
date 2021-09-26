package com.itheamc.earncrypto.utils

import android.content.Context
import android.util.Log

fun updateTheme(context: Context, isDark: Boolean) {
    LocalStorage(context).setDarkModeEnabled(isDark)
    Log.d("ThemeUtil", "changeTheme: $isDark")
}