package com.mistersomov.coinjet.data.network.api

import com.mistersomov.coinjet.data.network.model.CoinListDto
import com.mistersomov.coinjet.data.network.model.QuoteJsonContainerDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApiService {

    @GET(ENDPOINT_COIN_LIST)
    suspend fun getTopCoinList(
        @Query(QUERY_PARAM_LIMIT) limit: Int = QUERY_PARAM_LIMI