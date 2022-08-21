package com.mistersomov.coinjet.screen.coin.view.search

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mistersomov.coinjet.R
import com.mistersomov.coinjet.core_ui.CoinJetTheme
import com.mistersomov.coinjet.domain.model.Coin
import com.mistersomov.coinjet.screen.coin.model.SearchViewState
import kotlinx.coroutines.launch

@SuppressLint("CoroutineCreationDuringComposition")
@Composable
fun SearchViewGlobal(
    viewState: SearchViewState.Global,
    onItemClicked: (Coin) -> Unit
) {
    val scope = rememberCoroutineScope()
    val searchList = viewState.globalSearchList
    val listState = rememberLazyListState()
    val isFirstItemVisible by remember { derivedStateOf { listState.firstVisibleItemIndex == 0 } }

    if (!isFirstItemVisible) {
        scope.launch { listState.animateScrollToItem(0) }
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
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
            color