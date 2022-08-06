package com.mistersomov.coinjet.screen.coin.view.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.mistersomov.coinjet.core_ui.CoinJetTheme
import com.mistersomov.coinjet.domain.model.Coin

@Composable
fun SearchCoinDetails(
    modifier: Modifier = Modifier,
    coin: Coin?,
    onItemClicked: () -> Unit,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { onItemClicked.invoke() }
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = coin?.imageUrl,
            modifier = Modifier
                .padding(vertical = 10.dp)
              