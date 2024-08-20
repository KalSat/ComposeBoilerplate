package com.thoughtworks.boilerplate.data.network.animalApi

import com.thoughtworks.boilerplate.data.model.Animal
import com.thoughtworks.boilerplate.data.network.httpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.takeFrom

private const val baseUrl = "https://api.thecatapi.com/v1/"

suspend fun getCats(
    limit: Int = 20,
    page: Int = 1,
    order: String = "desc",
): List<Animal> {
    return httpClient.get {
        url {
            takeFrom(baseUrl + "images/search")
            parameters.apply {
                append("limit", "$limit")
                append("page", "$page")
                append("order", order)
            }
        }
    }.body()
}
