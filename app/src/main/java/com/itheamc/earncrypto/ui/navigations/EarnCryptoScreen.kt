package com.itheamc.earncrypto.ui.navigations

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.CardGiftcard
import androidx.compose.material.icons.filled.Games
import androidx.compose.material.icons.filled.Web
import androidx.compose.ui.graphics.vector.ImageVector

enum class Screens(val icon: ImageVector) {
    Apps(
        icon = Icons.Filled.Apps
    ),
    Games(
        icon = Icons.Filled.Games
    ),
    Websites(
        icon = Icons.Filled.Web
    ),
    Airdrops(
        icon = Icons.Filled.CardGiftcard
    );

    companion object {
        fun fromRoute(route: String?) =
            when (route?.substringBefore("/")) {
                Apps.name -> Apps
                Games.name -> Games
                Websites.name -> Websites
                Airdrops.name -> Airdrops
                else -> Apps
            }
    }
}