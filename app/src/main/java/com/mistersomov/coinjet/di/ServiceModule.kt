package com.mistersomov.coinjet.di

import com.mistersomov.coinjet.BuildConfig
import com.mistersomov.coinjet.data.network.interceptor.CoinProtocolInterceptor
import com.mistersomov.coinjet.data.service.CoinService
import com.mistersomov.coinjet.data.service.CoinServiceImpl
import com.mistersomov.coinjet.utils.addInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponen