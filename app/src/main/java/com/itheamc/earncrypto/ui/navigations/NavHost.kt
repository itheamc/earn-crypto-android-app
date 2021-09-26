package com.itheamc.earncrypto.ui.navigations

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import coil.annotation.ExperimentalCoilApi
import com.itheamc.earncrypto.ui.screens.AppsScreen
import com.itheamc.earncrypto.viewmodel.EarnCryptoViewModel

// NavHost
@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun EarnCryptoNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String,
    viewModel: EarnCryptoViewModel
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screens.Apps.name) {
            AppsScreen(viewModel = viewModel)
        }

        composable(Screens.Games.name) {

        }

        composable(Screens.Websites.name) {

        }

        composable(Screens.Airdrops.name) {

        }

        composable("Favourite") {

        }
    }
}