package com.itheamc.earncrypto.ui.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.itheamc.earncrypto.ui.components.appbar.EarnCryptoBottomAppBar
import com.itheamc.earncrypto.ui.components.drawer.EarnCryptoBottomDrawer
import com.itheamc.earncrypto.ui.components.tab.EarnCryptoTabs
import com.itheamc.earncrypto.ui.navigations.Screens
import com.itheamc.earncrypto.ui.theme.EarnCryptoTheme
import com.itheamc.earncrypto.utils.LocalStorage
import com.itheamc.earncrypto.viewmodel.EarnCryptoViewModel
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun EarnCryptoApp(viewModel: EarnCryptoViewModel) {
    val scaffoldState = rememberScaffoldState()
    val scope = rememberCoroutineScope()
    val bottomDrawerState = rememberBottomDrawerState(BottomDrawerValue.Closed)
    val screens = Screens.values().toList()
    val navController = rememberNavController()
    val backstackEntry = navController.currentBackStackEntryAsState()
    val currentScreen = Screens.fromRoute(
        backstackEntry.value?.destination?.route
    )

    val context = LocalContext.current
    val dark: Boolean by viewModel.isDark.observeAsState(initial = LocalStorage(context).isDarkMode())
    // For ThemeControl
//    val (dark, isDark) = remember {
//        mutableStateOf(LocalStorage(context = context).isDarkMode())
//    }

    EarnCryptoTheme(darkTheme = dark) {
        Scaffold(
            scaffoldState = scaffoldState,
            topBar = {
                EarnCryptoTabs(
                    screens = screens,
                    onSelected = { screen ->
                        scope.launch { if (bottomDrawerState.isExpanded || bottomDrawerState.isOpen) bottomDrawerState.close() }
                        navController.navigate(screen.name)
                    },
                    currentScreen = currentScreen
                )
            },
            bottomBar = {
                EarnCryptoBottomAppBar(scope = scope, bottomDrawerState = bottomDrawerState)
            },
            floatingActionButton = {
                FloatingActionButton(
                    backgroundColor = MaterialTheme.colors.surface,
                    onClick = { navController.navigate("Favourite") }
                ) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = "Favourite")
                }
            },
            floatingActionButtonPosition = FabPosition.End,
            isFloatingActionButtonDocked = true,
            drawerGesturesEnabled = false
        ) {
            EarnCryptoBottomDrawer(
                modifier = Modifier.padding(it),
                scope = scope,
                scaffoldState = scaffoldState,
                drawerState = bottomDrawerState,
                navController = navController,
                startDestination = Screens.Apps.name,
                viewModel = viewModel
            )
        }
    }
}