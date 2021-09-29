
package com.mistersomov.coinjet.di

import com.mistersomov.coinjet.data.network.interceptor.CoinProtocolInterceptor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet
import dagger.multibindings.Multibinds
import okhttp3.Interceptor
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class InterceptorModule {
    @Singleton
    @Binds
    @IntoSet
    abstract fun bindCoinProtocolInterceptor(impl: CoinProtocolInterceptor): Interceptor

    @Multibinds
    abstract fun interceptors(): Set<Interceptor>
}