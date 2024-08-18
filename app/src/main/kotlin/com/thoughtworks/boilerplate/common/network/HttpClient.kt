package com.thoughtworks.boilerplate.common.network

import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

private const val httpConnectTimeout: Long = 30 // seconds
private const val httpReadTimeout: Long = 30 // seconds
private const val httpWriteTimeout: Long = 30 // seconds

val sHttpClient: OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(httpConnectTimeout, TimeUnit.SECONDS)
    .readTimeout(httpReadTimeout, TimeUnit.SECONDS)
    .writeTimeout(httpWriteTimeout, TimeUnit.SECONDS)
    .addNetworkInterceptor(
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    )
    .addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()
        chain.proceed(request)
    }
    .build()
