package com.mistersomov.coinjet.data.service

import com.mistersomov.coinjet.data.network.api.CoinApiService
import retrofit2.Retrofit
import javax.inject.Inject

class CoinServiceImpl @Inject constructor(
    private val retrofit: Retrofit,
) : CoinService {

    override fun getService(): CoinApiService = retrofit.create(CoinApiService::class.java)
}