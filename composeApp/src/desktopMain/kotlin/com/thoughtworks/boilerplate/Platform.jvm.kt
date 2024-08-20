package com.thoughtworks.boilerplate

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.engine.java.Java

class JVMPlatform : Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()

actual fun createHttpClient(config: HttpClientConfig<*>.() -> Unit) = HttpClient(Java) {
    config(this)
}
