package com.thoughtworks.boilerplate.features.animals

import com.thoughtworks.boilerplate.shared.BaseUrl
import com.thoughtworks.boilerplate.shared.sRetrofitApiFactory
import retrofit2.http.GET
import retrofit2.http.Query

val sDogApi = sRetrofitApiFactory.createApi<DogApi>()

@BaseUrl("https://api.thedogapi.com/v1/")
interface DogApi {

    @GET("images/search")
    suspend fun getDogs(
        @Query("limit") limit: Int = 20,
        @Query("page") page: Int = 1,
        @Query("order") order: String = "desc",
    ): List<Animal>
}
