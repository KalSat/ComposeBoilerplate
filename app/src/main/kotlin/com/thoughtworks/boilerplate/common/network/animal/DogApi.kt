package com.thoughtworks.boilerplate.common.network.animal

import com.thoughtworks.boilerplate.common.network.BaseUrl
import com.thoughtworks.boilerplate.common.network.animal.model.Animal
import retrofit2.http.GET
import retrofit2.http.Query

@BaseUrl("https://api.thedogapi.com/v1/")
interface DogApi {

    @GET("images/search")
    suspend fun getDogs(
        @Query("limit") limit: Int = 20,
        @Query("page") page: Int = 1,
        @Query("order") order: String = "desc",
    ): List<Animal>
}
