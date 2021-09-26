package com.itheamc.earncrypto.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.itheamc.earncrypto.model.CryptoApp
import com.itheamc.earncrypto.utils.LocalStorage

class EarnCryptoViewModel(application: Application): AndroidViewModel(application) {
    // For Theme Setting
    private var _isDark = MutableLiveData(LocalStorage(application).isDarkMode())
    val isDark: LiveData<Boolean> = _isDark

    fun onThemeChanged(dark: Boolean) {
        _isDark.value = dark
    }

    // For Crypto Apps
    private var _cryptoApps = MutableLiveData(listOf<CryptoApp>())
    val cryptoApp: LiveData<List<CryptoApp>> = _cryptoApps
}