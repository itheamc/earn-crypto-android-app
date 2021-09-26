package com.itheamc.earncrypto.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import coil.transform.CircleCropTransformation
import com.itheamc.earncrypto.model.CryptoApp
import com.itheamc.earncrypto.utils.openLink
import kotlinx.coroutines.launch
import java.util.*

@ExperimentalMaterialApi
@ExperimentalCoilApi
@Composable
fun AppItemView(cryptoApp: CryptoApp) {

    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        onClick = { scope.launch { openLink(context, cryptoApp.linkUrl) } },
        shape = RoundedCornerShape(12.dp),
        elevation = 4.dp
    ) {
        Column(
            modifier = Modifier
                .padding(12.dp)
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.Start
        ) {

            //Rows to store Apps icon and name
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = cryptoApp.iconUrl,
                        builder = {
                            transformations(CircleCropTransformation())
                        }
                    ),
                    contentDescription = null,
                    modifier = Modifier.size(40.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Column(
                    modifier = Modifier.weight(1f),
                    verticalArrangement = Arrangement.Center
                ) {
                    // App Name
                    Text(
                        text = cryptoApp.name,
                        style = MaterialTheme.typography.h6,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    // Tagline
                    Text(
                        text = cryptoApp.tagLine,
                        style = MaterialTheme.typography.overline,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )
                }

                IconButton(
                    onClick = { /*TODO*/ },
                ) {
                    Icon(imageVector = Icons.Filled.Favorite, contentDescription = null)
                }

            }

            // Other Contents
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                modifier = Modifier.padding(start = 48.dp),
                text = "Coin:     ${cryptoApp.coin.uppercase(Locale.ENGLISH)}",
                style = MaterialTheme.typography.caption
            )
            Text(
                modifier = Modifier.padding(start = 48.dp),
                text = "Earning:     ${cryptoApp.dailyEarning} ${cryptoApp.coin.uppercase(Locale.ENGLISH)} per day",
                style = MaterialTheme.typography.caption
            )
        }
    }
}