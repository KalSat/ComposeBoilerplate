package com.thoughtworks.boilerplate.states

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.thoughtworks.boilerplate.shared.TokenStore
import com.thoughtworks.boilerplate.shared.sTokenStore

val sAuthState = AuthState()

class AuthState(private val tokenStore: TokenStore = sTokenStore) {

    var isLoggedIn by mutableStateOf(false)
        private set

    fun init() {
        isLoggedIn = tokenStore.hasToken()
    }

    fun login(token: String) {
        tokenStore.saveToken(token)
        isLoggedIn = true
    }

    fun logout() {
        tokenStore.clearToken()
        isLoggedIn = false
    }
}
