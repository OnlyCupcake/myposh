package com.mistersomov.coinjet.screen.coin.model

import com.mistersomov.coinjet.domain.model.Coin

sealed class SearchViewState {

    object Hide : SearchViewState()

    object FirstSearch : SearchViewState()

    object NoItems : SearchViewState()

    data class Recent(val recentSearchList: List<Coin>) : SearchViewState()

    data class Global(val globalSearchList: List<Coin>) : Searc