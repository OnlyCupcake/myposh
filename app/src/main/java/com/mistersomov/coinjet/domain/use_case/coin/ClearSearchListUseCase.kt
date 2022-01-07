package com.mistersomov.coinjet.domain.use_case.coin

import com.mistersomov.coinjet.di.qualifier.DefaultDispatcher
import com.mistersomov.coinjet.domain.repository.CoinRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ClearSearchListUseCase @Inject constructor(
    private val repository: CoinRepository,
    @DefaultDispatcher private val defaultDispatcher: CoroutineDispatcher,
) {
    suspend operator fun invoke() {
        withContext(defaultDispatcher) {
            repository.clearSearchList()
        }
    }
}