package com.mistersomov.coinjet.screen.coin.model

import com.mistersomov.coinjet.domain.model.Coin

sealed class SearchEvent {

    object Hide : SearchEvent()

    object ShowRecentSearch : SearchEvent()

    data class LaunchSearch(val query: String) : SearchEvent()

    data class Save(val coin: Coin) : SearchEvent()

    object ClearCache : SearchEvent()
}