package com.itheamc.earncrypto.utils

import android.content.Context
import android.content.SharedPreferences

class LocalStorage(
    private val context: Context?,
    private val sharedPreferences: SharedPreferences? = context?.getSharedPreferences(
        "${context.packageName}.SETTINGS",
        Context.MODE_PRIVATE
    )
) {

    // Function to store theme data
    fun setDarkModeEnabled(enabled: Boolean = false) {
        with(sharedPreferences?.edit()) {
            this?.putBoolean(StorageConstants.THEME.name, enabled)
            this?.apply()
        }
    }

    // Function to check if dark mode enabled
    fun isDarkMode(): Boolean {
        return with(sharedPreferences) {
            this?.getBoolean(StorageConstants.THEME.name, false)
        } ?: false
    }
}