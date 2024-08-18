package com.thoughtworks.boilerplate.common.network.animal

import com.thoughtworks.boilerplate.common.network.BaseUrl
import com.thoughtworks.boilerplate.common.network.animal.model.Animal
import com.thoughtworks.boilerplate.common.network.sRetrofitApiFactory
import retrofit2.http.GET
import retrofit2.http.Query

val sCatApi = sRetrofitApiFactory.createApi<CatApi>()

@BaseUrl("https://api.thecatapi.com/v1/")
interface CatApi {

    @GET("images/search")
    suspend fun getCats(
        @Query("limit") limit: Int = 20,
        @Query("page") page: Int = 1,
        @Query("order") order: String = "desc",
    ): List<Animal>
}
