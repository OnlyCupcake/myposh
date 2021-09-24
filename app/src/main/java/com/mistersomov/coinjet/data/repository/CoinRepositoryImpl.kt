package com.mistersomov.coinjet.data.repository

import com.mistersomov.coinjet.data.datasource.LocalDataSource
import com.mistersomov.coinjet.data.datasource.RemoteDataSource
import com.mistersomov.coinjet.data.toCoin
import com.mistersomov.coinjet.data.toCoinEntity
import com.mistersomov.coinjet.data.toSearchCoinEntity
import com.mistersomov.coinjet.di.qualifier.DefaultDispatcher
import com.mistersomov.coinjet.domain.model.Coin
import com.mistersomov.coinjet.domain.repository.CoinRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
) : CoinRepository {

    override fun getLatestCoinList(): Flow<List<Coin>> {
        return remoteDataSource.getLatestCoinList()
            .onEach { coinList -> saveCoinListToCache(coinList) }
            .flowOn(defaultDispatcher)
    }

    override fun getCoinBySymbol(symbol: String): Flow<Coin> {
        return localDataSource.getCoinBySymbol(symbol)
            .map { entity -> entity.toCoin() }
            .flowOn(defaultDispatcher)
    }

    override fun getRecentSearchList(): Flow<List<Coin>> {
        return localDataSource.getRecentSearchList()
            .map { entityList ->
                when {
                    entityList.isEmpty() -> emptyList()
                    else -> entityList
                        .distinctBy { it.symbol }
                        .map { entity -> entity.toCoin() }
                        .sortedByDescending { coin -> coin.mktCap }
                }
            }
            .flowOn(defaultDispatcher)
    }

    override suspend fun getCoinListByName(name: String): List<Coin> {
        return withContext(defaultDispatcher) {
            getCoinListFromCache()
                .filter { it.fullName.lowercase().contains(name.lowercase()) }
                .sortedByDescending { it.mktCap }
                .distinctBy { it.symbol }
        }
    }

    override suspend fun getCoinListBySymbol(symbol: String): List<Coin> {
        return withContext(defaultDispatcher) {
            getCoinListFromCache()
                .filter { it.symbol.lowercase().contains(symbol.lowercase()) }
                .sortedByDescending { it.mktCap }
                .distinctBy { it.symbol }
        }
    }

    override suspend fun saveSearchCoinToCache(coin: Coin) {
        withContext(defaultDispatcher) {
            localDataSource.saveSearchCoinToCache(coin.toSearchCoinEntity())
        }
    }

    override suspend fun clearSearchList() {
        withContext(defaultDispatcher) {
            localDataSource.clearSearchList()
        }