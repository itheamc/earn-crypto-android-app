package com.itheamc.earncrypto.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import coil.annotation.ExperimentalCoilApi
import com.itheamc.earncrypto.model.CryptoApp
import com.itheamc.earncrypto.ui.views.AppItemView
import com.itheamc.earncrypto.utils.getCryptoApps
import com.itheamc.earncrypto.viewmodel.EarnCryptoViewModel

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun AppsScreen(viewModel: EarnCryptoViewModel) {
    val cryptoApps: List<CryptoApp> by viewModel.cryptoApp.observeAsState(listOf())
    val lists = getCryptoApps()
    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        items(lists) { app ->
            AppItemView(cryptoApp = app)
        }
    }
}