package com.mistersomov.coinjet.screen.coin.model

import com.mistersomov.coinjet.domain.model.Coin

sealed class CoinDetailsViewState {

    object Hide : CoinDetailsViewState()

    data class SimpleDetails(val coin: Coin) : CoinDetailsViewState()

    data class FullDetails(val coin: Coin) : CoinDetailsViewState()
}