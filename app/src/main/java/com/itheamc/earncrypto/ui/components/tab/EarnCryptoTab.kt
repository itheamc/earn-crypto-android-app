package com.itheamc.earncrypto.ui.components.tab

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.itheamc.earncrypto.ui.navigations.Screens
import java.util.*

@Composable
fun EarnCryptoTabs(
    screens: List<Screens>,
    onSelected: (Screens) -> Unit,
    currentScreen: Screens
) {
    Surface(
        Modifier
            .height(TabHeight)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier.selectableGroup(),
            horizontalArrangement = Arrangement.Center
        ) {
            screens.forEach { screen ->
                EarnCryptoTab(
                    screen = screen,
                    onSelected = { onSelected(screen) },
                    selected = currentScreen == screen
                )
            }
        }
    }
}


// Individual Tab
@Composable
private fun EarnCryptoTab(
    screen: Screens,
    onSelected: () -> Unit,
    selected: Boolean
) {
    val color = MaterialTheme.colors.onSurface
    val durationMillis = if (selected) TabFadeInAnimationDuration else TabFadeOutAnimationDuration
    val animSpec = remember {
        tween<Color>(
            durationMillis = durationMillis,
            easing = LinearEasing,
            delayMillis = TabFadeInAnimationDelay
        )
    }
    val tabTintColor by animateColorAsState(
        targetValue = if (selected) color else color.copy(alpha = InactiveTabOpacity),
        animationSpec = animSpec
    )
    Row(
        modifier = Modifier
            .padding(12.dp) // For Margin
            .animateContentSize()
            .height(TabHeight)
            .clip(RoundedCornerShape(percent = 50))
            .selectable(
                selected = selected,
                onClick = onSelected,
                role = Role.Tab,
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(
                    bounded = false,
                    radius = Dp.Unspecified,
                    color = Color.Transparent
                )
            )
            .clearAndSetSemantics { contentDescription = screen.name }
//            .border(
//                width = if (selected) 1.dp else 0.dp,
//                brush = if (selected) SolidColor(color) else SolidColor(Color.Transparent),
//                shape = RoundedCornerShape(percent = 50)
//            )
            .background(
                brush = if (selected) SolidColor(color) else SolidColor(Color.Transparent),
                shape = RoundedCornerShape(percent = 50),
                alpha = 0.1f
            )
            .padding(horizontal = if (selected) 12.dp else 4.dp) // For Under Padding
            .shadow(
                elevation = if (selected) 50.dp else 0.dp,
                shape = RoundedCornerShape(percent = 50),
                clip = true
            ),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        Icon(imageVector = screen.icon, contentDescription = screen.name, tint = tabTintColor)
        if (selected) {
            Spacer(Modifier.width(8.dp))
            Text(
                text = screen.name.uppercase(Locale.getDefault()),
                color = tabTintColor,
                fontSize = 13.sp,
                fontWeight = FontWeight.SemiBold,
            )
        }
    }
}


private val TabHeight = 56.dp
private const val InactiveTabOpacity = 0.60f

private const val TabFadeInAnimationDuration = 150
private const val TabFadeInAnimationDelay = 100
private const val TabFadeOutAnimationDuration = 100