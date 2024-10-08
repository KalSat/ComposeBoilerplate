package com.thoughtworks.boilerplate.data.model

import com.google.gson.annotations.SerializedName

data class Animal(
    @SerializedName("id")
    val id: String = "",

    @SerializedName("url")
    val url: String = "",

    @SerializedName("width")
    val width: Int = 0,

    @SerializedName("height")
    val height: Int = 0,
)
