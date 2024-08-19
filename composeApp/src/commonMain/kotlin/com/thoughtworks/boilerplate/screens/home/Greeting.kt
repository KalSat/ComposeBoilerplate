package com.thoughtworks.boilerplate.screens.home

import com.thoughtworks.boilerplate.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}