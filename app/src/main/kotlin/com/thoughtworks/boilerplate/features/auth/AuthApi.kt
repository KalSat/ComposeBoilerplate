package com.thoughtworks.boilerplate.features.auth

import com.thoughtworks.boilerplate.shared.BaseUrl
import com.thoughtworks.boilerplate.shared.sRetrofitApiFactory
import retrofit2.http.Body
import retrofit2.http.POST

val sAuthApi = sRetrofitApiFactory.createApi<AuthApi>()

@BaseUrl("https://postman-echo.com/")
interface AuthApi {

    @POST("post")
    suspend fun login(@Body request: AuthRequest): AuthResponse
}
