
package com.mistersomov.coinjet.domain.use_case.coin

import com.mistersomov.coinjet.di.qualifier.DefaultDispatcher
import com.mistersomov.coinjet.domain.model.Coin
import com.mistersomov.coinjet.domain.repository.CoinRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetCoinListBySearchUseCase @Inject constructor(
    private val repository: CoinRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
) {
    suspend operator fun invoke(query: String): List<Coin> {
        return withContext(defaultDispatcher)  {
            when {
                query[0] == '#' -> {
                    val formattedQuery = query.trim { it == '#' }

                    repository.getCoinListBySymbol(formattedQuery)
                }
                else -> repository.getCoinListByName(query.trimIndent())
            }
        }
    }
}