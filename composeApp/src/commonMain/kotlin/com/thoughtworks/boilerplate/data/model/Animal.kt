package com.thoughtworks.boilerplate.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Animal(
    val id: String = "",

    val url: String = "",

    val width: Int? = 0,

    val height: Int? = 0,
)
