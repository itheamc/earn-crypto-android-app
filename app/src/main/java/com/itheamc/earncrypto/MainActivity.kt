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
import com.itheamc.earncrypto.ui.app.EarnCryptoApp
import com.itheamc.earncrypto.ui.theme.EarnCryptoTheme
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

@Composable
fun Greeting(name: String) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello $name")
        IconButton(onClick = { /*TODO*/ }) {
            Icon(imageVector = Icons.Filled.Games, contentDescription = "")
        }


    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EarnCryptoTheme {
        Greeting("Android")
    }
}