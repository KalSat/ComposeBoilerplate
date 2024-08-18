package com.thoughtworks.boilerplate.common.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val defaultBaseUrl = "https://thoughtworks-mobile-2018.herokuapp.com/"
val sRetrofitApiFactory = RetrofitApiFactory()

class RetrofitApiFactory constructor(
    private val httpClient: OkHttpClient = sHttpClient,
) {
    private val clientMap: MutableMap<String, Retrofit> = mutableMapOf()

    inline fun <reified T> createApi(): T = getRetrofit(T::class.java).create(T::class.java)

    fun <T> getRetrofit(clazz: Class<T>): Retrofit {
        val baseUrl = getBaseUrl(clazz)
        return clientMap[baseUrl] ?: createRetrofit(baseUrl).also { clientMap[baseUrl] = it }
    }

    private fun <T> getBaseUrl(clazz: Class<T>): String {
        val baseUrl = clazz.getAnnotation(BaseUrl::class.java)?.value
        return baseUrl ?: defaultBaseUrl
    }

    private fun createRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class BaseUrl(val value: String)
