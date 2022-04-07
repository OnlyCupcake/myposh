package com.mistersomov.coinjet.screen.coin

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mistersomov.coinjet.R
import com.mistersomov.coinjet.core_ui.CoinJetTheme
import com.mistersomov.coinjet.core_ui.component.Search
import com.mistersomov.coinjet.screen.coin.model.*
import com.mistersomov.coinjet.screen.coin.view.CoinViewDisplay
import com.mistersomov.coinjet.screen.coin.view.CoinViewLoading
import com.mistersomov.coinjet.screen.coin.view.CoinViewSimpleDetails
import com.mistersomov.coinjet.screen.coin.view.search.SearchViewFirst
import com.mistersomov.coinjet.screen.coin.view.search.SearchViewGlobal
import com.mistersomov.coinjet.screen.coin.view.search.SearchViewNoItems
import com.mistersomov.coinjet.screen.coin.view.search.SearchViewRecent
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CoinScreen(navController: NavController, viewModel: CoinViewModel = hiltViewModel()) {
    val viewState = viewModel.coinViewState.collectAsState()
    val searchViewState = viewModel.searchViewState.collectAsState()
    val detailsViewState = viewModel.coinDetailsViewState.collectAsState()

    val scope = rememberCoroutineScope()
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Concealed)

    LaunchedEffect(key1 = scaffoldState, block = {
        scaffoldState.reveal()
    })

    BackdropScaffold(
        scaffoldState = scaffoldState,
        appBar = { },
        frontLayerScrimColor = Color.Unspecified,
        backLayerBackgroundColor = CoinJetTheme.colors.primary,
        peekHeight = 80.dp,
        backLayerContent = {
            Search(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                placeholderText = stringResource(id = R.string.crypto_search_placeholder),
                onFocusChanged = {
                    scope.launch { scaffoldState.reveal() }
                    with(viewModel) {
                        obtainSearchEvent(SearchEvent.ShowRecentSearch)
                        cancelSimpleDetailsJob()
                    }
                },
                onValueChanged = { viewModel.obtainSearchEvent(SearchEvent.LaunchSearch(it)) },
                onCancelClicked = { viewModel.obtainSearchEvent(SearchEvent.Hide) },
                onRemoveQuery = { viewModel.obtainSearchEvent(SearchEvent.ShowRecentSearch) },
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                when (val currentSearchState = searchViewState.value) {
                    is SearchViewState.Hide -> {}
                    is SearchViewState.NoItems -> SearchViewNoItems()
                    is SearchViewState.FirstSearch -> SearchViewFirst()
                    is SearchViewState.Recent ->
                        AnimatedVisibility(visible = true) {
                            SearchViewRecent(
                                viewState = currentSearchState,
                                onItemClicked = {
                                    scope.launch { scaffoldState.reveal() }
                                    viewModel.obtainEvent(CoinEvent.Click(it.symbol))
                                },
                                onClearClicked = { viewModel.obtainSearchEvent(SearchEvent.ClearCache) }
                            )
                        }
                    is SearchViewState.Global ->
                        AnimatedVisibility(visible = true) {
                            SearchViewGlobal(
                                viewState = currentSearchState,
                                onItemClicked = {
                                    scope.launch { scaffoldState.reveal() }
                                    with(viewModel) {
                            