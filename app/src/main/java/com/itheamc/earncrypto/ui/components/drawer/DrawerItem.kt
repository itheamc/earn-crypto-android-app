package com.itheamc.earncrypto.ui.components.drawer


import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.itheamc.earncrypto.model.DrawerItem
import com.itheamc.earncrypto.utils.*
import com.itheamc.earncrypto.viewmodel.EarnCryptoViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Composable
fun BottomDrawerItem(
    drawerItem: DrawerItem,
    scope: CoroutineScope,
    scaffoldState: ScaffoldState,
    viewModel: EarnCryptoViewModel
) {
    val context = LocalContext.current

    // To control the switch
    var checked by remember {
        mutableStateOf(LocalStorage(context).isDarkMode())
    }

    Row(
        modifier = Modifier
            .padding(vertical = 4.dp)
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable(
                enabled = drawerItem.label != MenuConstants.Theme.label
            ) {
                scope.launch {
                    handleClick(
                        drawerItem = drawerItem,
                        context = context
                    )
                }
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.padding(start = 12.dp),
            imageVector = if (drawerItem.label != MenuConstants.Theme.label) drawerItem.icon else if (checked) drawerItem.icon else Icons.Filled.LightMode,
            contentDescription = drawerItem.label
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = if (drawerItem.label != MenuConstants.Theme.label) drawerItem.label else if (checked) "Dark Mode (Enabled)" else "Dark Mode (Disabled)"
        )

        // For theme menu only
        if (drawerItem.label == MenuConstants.Theme.label) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Spacer(modifier = Modifier.weight(1f, true))
                Switch(
                    checked = checked,
                    onCheckedChange = {
                        checked = !checked
                        viewModel.onThemeChanged(checked)
                        scope.launch { updateTheme(context, checked) }
                    }
                )
            }
        }
    }


}

// FUnction to handle item click
private fun handleClick(drawerItem: DrawerItem, context: Context?) {
    when (drawerItem.label) {
        MenuConstants.Share.label -> shareNow(context)
        MenuConstants.Rate.label -> rateNow(context)
        MenuConstants.ReportBugs.label -> reportBugs(context)
        else -> Unit
    }
}