
package com.mistersomov.coinjet.domain.repository

import com.mistersomov.coinjet.domain.model.Coin
import kotlinx.coroutines.flow.Flow

interface CoinRepository {
    fun getLatestCoinList(): Flow<List<Coin>>

    fun getCoinBySymbol(symbol: String): Flow<Coin>

    suspend fun getCoinListByName(name: String): List<Coin>

    suspend fun getCoinListBySymbol(symbol: String): List<Coin>

    suspend fun saveSearchCoinToCache(coin: Coin)

    fun getRecentSearchList(): Flow<List<Coin>>

    suspend fun clearSearchList()
}