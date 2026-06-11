package com.thoughtworks.boilerplate.data.network

import java.util.concurrent.TimeUnit
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

private const val HTTP_CONNECT_TIMEOUT: Long = 30 // seconds
private const val HTTP_READ_TIMEOUT: Long = 30 // seconds
private const val HTTP_WRITE_TIMEOUT: Long = 30 // seconds

val sHttpClient: OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
    .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
    .writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
    .addNetworkInterceptor(
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY),
    )
    .addInterceptor { chain ->
        val request = chain.request().newBuilder()
            .addHeader("Content-Type", "application/json")
            .addHeader("Accept", "application/json")
            .build()
        chain.proceed(request)
    }
    .build()
