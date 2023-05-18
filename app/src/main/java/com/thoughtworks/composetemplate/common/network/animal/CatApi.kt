package com.thoughtworks.composetemplate.common.network.animal

import com.thoughtworks.composetemplate.common.network.BaseUrl
import com.thoughtworks.composetemplate.common.network.animal.model.Animal
import retrofit2.http.GET
import retrofit2.http.Query

@BaseUrl("https://api.thecatapi.com/v1/")
interface CatApi {

    @GET("images/search")
    suspend fun getCats(
        @Query("limit") limit: Int = 20,
        @Query("page") page: Int = 1,
        @Query("order") order: String = "desc",
    ): List<Animal>
}
