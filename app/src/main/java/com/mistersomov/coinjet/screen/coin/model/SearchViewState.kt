package com.mistersomov.coinjet.screen.coin.model

import com.mistersomov.coinjet.domain.model.Coin

sealed class SearchViewState {

    object Hide : SearchViewState()

    object FirstSearch : Se