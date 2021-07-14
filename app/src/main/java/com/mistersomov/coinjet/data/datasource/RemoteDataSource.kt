
package com.mistersomov.coinjet.data.datasource

import com.mistersomov.coinjet.domain.model.Coin
import kotlinx.coroutines.flow.Flow

interface RemoteDataSource {
    fun getLatestCoinList(): Flow<List<Coin>>
}