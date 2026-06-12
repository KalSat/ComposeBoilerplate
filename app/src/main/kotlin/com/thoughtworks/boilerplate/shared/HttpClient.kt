package com.thoughtworks.boilerplate.shared

import com.thoughtworks.boilerplate.states.AuthState
import com.thoughtworks.boilerplate.states.sAuthState
import java.util.concurrent.TimeUnit
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor

private const val HTTP_CONNECT_TIMEOUT: Long = 30 // seconds
private const val HTTP_READ_TIMEOUT: Long = 30 // seconds
private const val HTTP_WRITE_TIMEOUT: Long = 30 // seconds

val sHttpClient: OkHttpClient = OkHttpClient.Builder()
    .connectTimeout(HTTP_CONNECT_TIMEOUT, TimeUnit.SECONDS)
    .readTimeout(HTTP_READ_TIMEOUT, TimeUnit.SECONDS)
    .writeTimeout(HTTP_WRITE_TIMEOUT, TimeUnit.SECONDS)
    .addInterceptor(TokenInterceptor())
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

internal class TokenInterceptor(
    private val tokenStore: TokenStore = sTokenStore,
    private val authState: AuthState = sAuthState,
) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        tokenStore.getToken()?.let { token ->
            requestBuilder.addHeader("Authorization", "Bearer $token")
        }
        val response = chain.proceed(requestBuilder.build())
        if (response.code == 401) {
            authState.logout()
        }
        return response
    }
}
