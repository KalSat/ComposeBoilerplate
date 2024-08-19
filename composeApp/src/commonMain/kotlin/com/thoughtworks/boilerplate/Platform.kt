package com.thoughtworks.boilerplate

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform