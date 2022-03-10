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
        scaffoldState