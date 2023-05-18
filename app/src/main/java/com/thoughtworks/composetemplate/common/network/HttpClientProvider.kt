package com.thoughtworks.composetemplate.common.network

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor

private const val httpConnectTimeout: Long = 30 // seconds
private const val httpReadTimeout: Long = 30 // seconds
private const val httpWriteTimeout: Long = 30 // seconds
private const val maxSize: Long = 10 * 1024 * 1024 // 10MB

@Singleton
class HttpClientProvider @Inject constructor(
    @ApplicationContext val context: Context,
) : Provider<OkHttpClient> {

    private val httpClient: OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(httpConnectTimeout, TimeUnit.SECONDS)
        .readTimeout(httpReadTimeout, TimeUnit.SECONDS)
        .writeTimeout(httpWriteTimeout, TimeUnit.SECONDS)
        .cache(Cache(File(context.cacheDir, "http_cache"), maxSize))
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

    override fun get(): OkHttpClient = httpClient
}
