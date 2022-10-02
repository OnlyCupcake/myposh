package com.mistersomov.coinjet.screen.coin.view.search

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mistersomov.coinjet.R
import com.mistersomov.coinjet.core_ui.CoinJetTheme
import com.mistersomov.coinjet.domain.model.Coin
import com.mistersomov.coinjet.screen.coin.model.SearchViewState

@Composable
fun SearchViewRecent(
    viewState: SearchViewState.Recent,
    onItemClicked: (Coin) -> Unit,
    onClearClicked: () -> Unit,
) {
    val recentSearchList = viewState.recentSearchList

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = stringResource(id = R.string.crypto_search_headline_title_recent_searches),
                color = CoinJetTheme.colors.surfaceVariant,
                style = CoinJetTheme.typography.titleMedium
            )
            TextButton(
                onClick = { onClearClicked.invoke() },
                shape = RoundedCornerShape(24.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.crypto_search_clear_cache),
                    color = CoinJetTheme.colors.onPrimary
                )
            }
        }
        Divider(
            modifier = Modifier.fillMaxWidth(), color = CoinJetTheme.colors.surfaceVariant
        )
  