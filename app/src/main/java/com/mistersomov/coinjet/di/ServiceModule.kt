package com.mistersomov.coinjet.di

import com.mistersomov.coinjet.BuildConfig
import com.mistersomov.coinjet.data.network.interceptor.CoinProtocolInterceptor
import com.mistersomov.coinjet.data.service.CoinService
import com.mistersomov.coinjet.data.service.CoinServiceImpl
import com.mistersomov.coinjet.utils.addInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Singleton
    @Provides
    fun provideOkkHttp(interceptors: MutableSet<Interceptor>): OkHttpClient {
        val interceptorList: ArrayList<Interceptor> = ArrayList(interceptors)
        return OkHttpClient.Builder()
            .addInterceptor(interceptorList, CoinProtocolInterceptor::class.java)
            .connectTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .baseUrl(BuildConfig.bas