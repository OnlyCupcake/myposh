
package com.mistersomov.coinjet.data.datasource

import com.mistersomov.coinjet.data.database.dao.CoinDao
import com.mistersomov.coinjet.data.database.dao.SearchCoinDao
import com.mistersomov.coinjet.data.database.entity.CoinEntity
import com.mistersomov.coinjet.data.database.entity.SearchCoinEntity
import com.mistersomov.coinjet.di.qualifier.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val coinDao: CoinDao,
    private val searchCoinDao: SearchCoinDao,
    @IoDispatcher private val ioDispatcher: CoroutineDispatcher,
) : LocalDataSource {
    override suspend fun saveCoinListToCache(coinList: List<CoinEntity>) {
        withContext(ioDispatcher) {
            coinDao.insertAll(coinList)
        }
    }

    override suspend fun getCoinListFromCache(): List<CoinEntity> {
        return withContext(ioDispatcher) {
            coinDao.getAll()
        }
    }

    override fun getCoinBySymbol(symbol: String): Flow<CoinEntity> {
        return coinDao.getBySymbol(symbol).flowOn(ioDispatcher)
    }

    override suspend fun deleteCoinListFromCache() = withContext(ioDispatcher) {
        coinDao.deleteAll()
    }

    override suspend fun saveSearchCoinToCache(coin: SearchCoinEntity) = withContext(ioDispatcher) {
        searchCoinDao.insertByEntity(coin)
    }

    override fun getRecentSearchList(): Flow<List<SearchCoinEntity>> =
        searchCoinDao.getAll().flowOn(ioDispatcher)

    override suspend fun clearSearchList() = withContext(ioDispatcher) {
        searchCoinDao.deleteAll()
    }
}