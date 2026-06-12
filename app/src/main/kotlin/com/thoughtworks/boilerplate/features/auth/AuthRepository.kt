package com.thoughtworks.boilerplate.features.auth

import com.thoughtworks.boilerplate.states.AuthState
import com.thoughtworks.boilerplate.states.sAuthState
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthRepository(
    private val authApi: AuthApi = sAuthApi,
    private val authState: AuthState = sAuthState,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    suspend fun login(username: String, password: String) = withContext(dispatcher) {
        val response = authApi.login(AuthRequest(username, password))
        authState.login(response.token)
    }

    fun logout() {
        authState.logout()
    }
}
