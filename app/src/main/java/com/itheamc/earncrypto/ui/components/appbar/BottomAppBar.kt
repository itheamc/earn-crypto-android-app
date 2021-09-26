package com.itheamc.earncrypto.ui.components.appbar

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@ExperimentalMaterialApi
@Composable
fun EarnCryptoBottomAppBar(
    scope: CoroutineScope,
    bottomDrawerState: BottomDrawerState
) {
    BottomAppBar(
        cutoutShape = RoundedCornerShape(percent = 50)
    ) {
        // It is recommended to have leading icon such as menu icon
        // should have high content alpha
        // So we have set the contentAlpha high for the menu icon
        // with the help of CompositionLocalProvider
        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.high) {
            IconButton(onClick = { scope.launch { if (bottomDrawerState.isOpen || bottomDrawerState.isExpanded) bottomDrawerState.close() else bottomDrawerState.open() } }) {
                Icon(
                    imageVector = if (bottomDrawerState.isOpen || bottomDrawerState.isExpanded) Icons.Filled.Close else Icons.Filled.Menu,
                    contentDescription = "menu icon for bottom app bar"
                )
            }
        }
    }
}