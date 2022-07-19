
package com.mistersomov.coinjet.screen.coin.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mistersomov.coinjet.R
import com.mistersomov.coinjet.core_ui.CoinJetTheme
import com.mistersomov.coinjet.core_ui.effect.animateDigitColor
import com.mistersomov.coinjet.domain.model.Coin
import com.mistersomov.coinjet.utils.formatBigDecimalsToDisplay
import com.mistersomov.coinjet.utils.formatCurrencyToDisplay
import kotlinx.coroutines.launch

@Composable
fun CoinViewSimpleDetails(
    modifier: Modifier = Modifier,
    coin: Coin,
    onCancelClicked: () -> Unit
) {
    val scope = rememberCoroutineScope()
    val favoriteIconId = remember { mutableStateOf(R.drawable.favorite_outline) }
    var favoriteIconTint = CoinJetTheme.colors.primaryContainer
    val dividerColorList: List<Color> = listOf(
        CoinJetTheme.colors.primary,
        CoinJetTheme.colors.onPrimary,
        CoinJetTheme.colors.primary
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = { onCancelClicked.invoke() }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.close_circle),
                    contentDescription = null,
                    tint = CoinJetTheme.colors.onPrimary
                )

            }
            Text(
                text = coin.fullName,
                style = CoinJetTheme.typography.titleLarge,
                color = CoinJetTheme.colors.onPrimary
            )
            IconButton(onClick = {
                scope.launch {
                    favoriteIconId.value = when (favoriteIconId.value) {
                        R.drawable.favorite_outline -> R.drawable.favorite_bold
                        else -> R.drawable.favorite_outline
                    }
                }
            }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = favoriteIconId.value),
                    contentDescription = null,
                    tint = favoriteIconTint
                )
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(6.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                model = coin.imageUrl,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape),
                contentDescription = null,
                alignment = Alignment.Center,
                contentScale = ContentScale.Crop
            )
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.coin_details_high_day),
                    style = CoinJetTheme.typography.labelSmall,
                    color = CoinJetTheme.colors.primaryContainer
                )
                Text(
                    text = coin.high24Hour.formatCurrencyToDisplay(),
                    style = CoinJetTheme.typography.titleMedium,
                    color = CoinJetTheme.colors.onPrimary
                )
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
                Text(
                    text = stringResource(id = R.string.coin_details_low_day),
                    style = CoinJetTheme.typography.labelSmall,
                    color = CoinJetTheme.colors.primaryContainer
                )
                Text(
                    text = coin.low24Hour.formatCurrencyToDisplay(),
                    style = CoinJetTheme.typography.titleMedium,
                    color = CoinJetTheme.colors.onPrimary
                )
            }
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(100.dp)
                    .background(brush = Brush.verticalGradient(dividerColorList))
            )
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(id = R.string.coin_details_open_day),
                    style = CoinJetTheme.typography.labelSmall,
                    color = CoinJetTheme.colors.primaryContainer
                )
                Text(
                    text = coin.open24Hour.formatCurrencyToDisplay(),
                    style = CoinJetTheme.typography.titleMedium,
                    color = CoinJetTheme.colors.onPrimary
                )
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
                Text(
                    text = stringResource(id = R.string.coin_details_market_cap),
                    style = CoinJetTheme.typography.labelSmall,
                    color = CoinJetTheme.colors.primaryContainer
                )
                Text(
                    text = coin.mktCap.formatBigDecimalsToDisplay(),
                    style = CoinJetTheme.typography.titleMedium,
                    color = CoinJetTheme.colors.onPrimary
                )
            }
            Box(
                modifier = Modifier
                    .width(1.dp)
                    .height(100.dp)
                    .background(brush = Brush.verticalGradient(dividerColorList))
            )
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = String.format(
                        stringResource(id = R.string.coin_details_volume),
                        coin.symbol
                    ),
                    style = CoinJetTheme.typography.labelSmall,
                    color = CoinJetTheme.colors.primaryContainer
                )
                Text(
                    text = coin.volume24Hour.formatBigDecimalsToDisplay(),
                    style = CoinJetTheme.typography.titleMedium,
                    color = CoinJetTheme.colors.onPrimary
                )
                Spacer(
                    modifier = Modifier.height(12.dp)
                )
                Text(
                    text = String.format(
                        stringResource(id = R.string.coin_details_volume),
                        coin.toSymbol
                    ),
                    style = CoinJetTheme.typography.labelSmall,
                    color = CoinJetTheme.colors.primaryContainer
                )
                Text(
                    text = coin.volume24hourTo.formatBigDecimalsToDisplay(),
                    style = CoinJetTheme.typography.titleMedium,
                    color = CoinJetTheme.colors.onPrimary
                )
            }
        }
        Spacer(
            modifier = Modifier.height(6.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = '#' + coin.symbol + " / " + coin.toSymbol,
                    style = CoinJetTheme.typography.titleMedium,
                    color = CoinJetTheme.colors.primaryContainer
                )
                Text(
                    text = coin.price.formatCurrencyToDisplay(),
                    style = CoinJetTheme.typography.headlineMedium,
                    color = animateDigitColor(
                        digit = coin.price,
                        initialColor = CoinJetTheme.colors.onPrimary
                    )
                )
            }
            IconButton(onClick = { }) {
                Icon(
                    imageVector = ImageVector.vectorResource(id = R.drawable.maximize_square),
                    contentDescription = null,
                    tint = CoinJetTheme.colors.onPrimary
                )
            }
        }
    }
}