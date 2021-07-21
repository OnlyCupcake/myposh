package com.mistersomov.coinjet.data.network.api

import com.mistersomov.coinjet.data.network.model.CoinListDto
import com.mistersomov.coinjet.data.network.model.QuoteJsonContainerDto
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinApiService {

    @GET(ENDPOINT_COIN_LIST)
    suspend fun getTopCoinList(
        @Query(QUERY_PARAM_LIMIT) limit: Int = QUERY_PARAM_LIMIT_DEFAULT,
        @Query(QUERY_PARAM_TO_SYMBOL) toSymbol: String = QUERY_PARAM_TO_SYMBOL_DEFAULT,
    ): CoinListDto

    @GET(ENDPOINT_QUOTE_LIST)
    suspend fun getQuoteList(
        @Query(QUERY_PARAM_FROM_SYMBOLS) fromSymbols: String,
        @Query(QUERY_PARAM_TO_SYMBOLS) toSymbols: String = QUERY_PARAM_TO_SYMBOL_DEFAULT,
        @Query(QUERY_PARAM_RELAXE