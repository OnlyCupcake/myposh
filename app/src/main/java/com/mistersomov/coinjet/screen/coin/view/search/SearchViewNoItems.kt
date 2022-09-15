
package com.mistersomov.coinjet.screen.coin.view.search

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mistersomov.coinjet.R
import com.mistersomov.coinjet.core_ui.CoinJetTheme

@Composable
fun SearchViewNoItems() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 10.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(id = R.string.crypto_search_headline_title),
            color = CoinJetTheme.colors.surfaceVariant,
            style = CoinJetTheme.typography.titleMedium
        )
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp),
            color = CoinJetTheme.colors.surfaceVariant
        )
        Text(
            modifier = Modifier
                .padding(vertical = 10.dp)
                .align(Alignment.CenterHorizontally),
            text = stringResource(id = R.string.crypto_search_headline_title_no_items),
            color = CoinJetTheme.colors.surfaceVariant,
            style = CoinJetTheme.typography.titleSmall
        )
    }
}