package com.thoughtworks.boilerplate

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect fun createHttpClient(config: HttpClientConfig<*>.() -> Unit = {}): HttpClient
