package com.mistersomov.coinjet.utils

import okhttp3.Interceptor
import okhttp3.OkHttpClient

fun <T : Any> OkHttpClient.Builder.addInterceptor(
    interceptors: List<Interceptor>,
    interceptorType: Class<T>
): OkHttpClient.Builder {
    interceptors
        .filter { interceptorType.isInstance(it) }
        .forEach(this::addInterceptor)

    return this
}