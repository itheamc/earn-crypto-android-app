package com.itheamc.earncrypto.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itheamc.earncrypto.utils.LocalStorage

class EarnCryptoViewModel(application: Application): AndroidViewModel(application) {
    private var _isDark = MutableLiveData(LocalStorage(application).isDarkMode())
    val isDark: LiveData<Boolean> = _isDark

    fun onThemeChanged(dark: Boolean) {
        _isDark.value = dark
    }
}