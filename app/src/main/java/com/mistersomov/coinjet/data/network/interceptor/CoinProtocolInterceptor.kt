
package com.mistersomov.coinjet.data.network.interceptor

import com.mistersomov.coinjet.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class CoinProtocolInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader(HEADER_API_KEY_NAME, BuildConfig.apiKey)
            .build()

        return chain.proceed(request)
    }

    companion object {
        //Headers
        private const val HEADER_API_KEY_NAME = "authorization"
    }
}