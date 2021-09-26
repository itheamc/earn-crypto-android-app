package com.itheamc.earncrypto.model

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.ui.graphics.vector.ImageVector
import com.itheamc.earncrypto.utils.MenuConstants

data class DrawerItem(val id: Int, val label: String, val icon: ImageVector)

fun getDrawerItems(): List<DrawerItem> {
    val items = arrayListOf<DrawerItem>()
    items.add(DrawerItem(1, MenuConstants.Theme.label, Icons.Filled.DarkMode))
    items.add(DrawerItem(2, MenuConstants.Share.label, Icons.Filled.Share))
    items.add(DrawerItem(3, MenuConstants.Rate.label, Icons.Filled.RateReview))
    items.add(DrawerItem(4, MenuConstants.ReportBugs.label, Icons.Filled.BugReport))
    items.add(DrawerItem(5, MenuConstants.PrivacyPolicy.label, Icons.Filled.PrivacyTip))

    return items
}