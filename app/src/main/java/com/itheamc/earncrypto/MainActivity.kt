package com.itheamc.earncrypto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import coil.annotation.ExperimentalCoilApi
import com.itheamc.earncrypto.model.CryptoApp
import com.itheamc.earncrypto.ui.app.EarnCryptoApp
import com.itheamc.earncrypto.ui.theme.EarnCryptoTheme
import com.itheamc.earncrypto.ui.views.AppItemView
import com.itheamc.earncrypto.viewmodel.EarnCryptoViewModel

@ExperimentalMaterialApi
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<EarnCryptoViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EarnCryptoApp(viewModel = viewModel)
        }
    }
}


@ExperimentalMaterialApi
@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val app = CryptoApp(
        id = 1,
        name = "Cloud Earning PHT",
        tagLine = "Mine crypto on your mobile for free.",
        coin = "PHT",
        dailyEarning = 9.0,
        desc = "",
        iconUrl = "https://pbs.twimg.com/profile_images/1112577903399710720/iSkQ2ur-_400x400.png",
        linkUrl = "https://play.google.com/store/apps/details?id=com.cloud.earning",
        views = 100
    )
    EarnCryptoTheme {
        AppItemView(cryptoApp = app)
    }
}