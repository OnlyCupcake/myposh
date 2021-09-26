package com.mistersomov.coinjet.data.service

import com.mistersomov.coinjet.data.network.api.CoinApiService

interface CoinService {

    fun getService(): CoinApiService
}