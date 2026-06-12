package com.thoughtworks.boilerplate.features.auth

import com.google.gson.annotations.SerializedName

data class AuthRequest(
    @SerializedName("username") val username: String,
    @SerializedName("password") val password: String,
)

data class AuthResponse(
    @SerializedName("data") val data: Map<String, Any>?,
    @SerializedName("json") val json: Map<String, Any>?,
    @SerializedName("url") val url: String?,
) {
    val token: String
        get() = "fake_token_${data?.get("username") ?: "unknown"}"
}
