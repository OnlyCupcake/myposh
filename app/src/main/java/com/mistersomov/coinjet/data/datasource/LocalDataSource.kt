
package com.mistersomov.coinjet.data.datasource

import com.mistersomov.coinjet.data.database.entity.CoinEntity
import com.mistersomov.coinjet.data.database.entity.SearchCoinEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    suspend fun getCoinListFromCache(): List<CoinEntity>

    fun getCoinBySymbol(symbol: String): Flow<CoinEntity>

    suspend fun saveCoinListToCache(coinList: List<CoinEntity>)

    suspend fun deleteCoinListFromCache()

    suspend fun saveSearchCoinToCache(coin: SearchCoinEntity)

    fun getRecentSearchList(): Flow<List<SearchCoinEntity>>

    suspend fun clearSearchList()
}