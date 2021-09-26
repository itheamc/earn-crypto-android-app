package com.itheamc.earncrypto.ui.components.drawer

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.itheamc.earncrypto.model.getDrawerItems
import com.itheamc.earncrypto.ui.navigations.EarnCryptoNavHost
import com.itheamc.earncrypto.viewmodel.EarnCryptoViewModel
import kotlinx.coroutines.CoroutineScope

@ExperimentalCoilApi
@ExperimentalMaterialApi
@Composable
fun EarnCryptoBottomDrawer(
    modifier: Modifier,
    drawerState: BottomDrawerState,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    navController: NavHostController,
    startDestination: String,
    viewModel: EarnCryptoViewModel
) {
    BottomDrawer(
        gesturesEnabled = drawerState.isOpen,
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(modifier = modifier, scope = scope, scaffoldState = scaffoldState, viewModel = viewModel)
        }
    ) {
        EarnCryptoNavHost(
            modifier = modifier,
            navController = navController,
            startDestination = startDestination,
            viewModel = viewModel
        )
    }
}


// Drawer Content
@Composable
private fun DrawerContent(modifier: Modifier, scope: CoroutineScope, scaffoldState: ScaffoldState, viewModel: EarnCryptoViewModel) {
    val drawerItems = getDrawerItems()

    LazyColumn(
        modifier = modifier
            .padding(16.dp)
            .fillMaxSize()
    ) {
        items(drawerItems) { drawerItem ->
            BottomDrawerItem(drawerItem = drawerItem, scope = scope, scaffoldState = scaffoldState, viewModel = viewModel)
        }
    }
}