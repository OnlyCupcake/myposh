
package com.mistersomov.coinjet.domain.use_case.coin

import com.mistersomov.coinjet.di.qualifier.DefaultDispatcher
import com.mistersomov.coinjet.domain.model.Coin
import com.mistersomov.coinjet.domain.repository.CoinRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class GetCoinBySymbolUseCase @Inject constructor(
    private val repository: CoinRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
) {
    operator fun invoke(symbol: String): Flow<Coin> {
        return repository.getCoinBySymbol(symbol).flowOn(defaultDispatcher)
    }
}