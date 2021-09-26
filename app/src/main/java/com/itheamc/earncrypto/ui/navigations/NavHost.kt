package com.itheamc.earncrypto.ui.navigations

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

// NavHost
@Composable
fun EarnCryptoNavHost(
    modifier: Modifier,
    navController: NavHostController,
    startDestination: String,
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable(Screens.Games.name) {

        }

        composable(Screens.Websites.name) {

        }

        composable(Screens.Airdrops.name) {

        }

        composable("Search") {

        }
    }
}