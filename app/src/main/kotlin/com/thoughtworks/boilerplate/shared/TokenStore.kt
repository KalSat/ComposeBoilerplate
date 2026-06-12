package com.thoughtworks.boilerplate.shared

import android.content.Context
import android.content.SharedPreferences

val sTokenStore = TokenStore()

class TokenStore(private val prefs: SharedPreferences? = null) {

    private companion object {
        const val PREF_NAME = "auth_prefs"
        const val TOKEN_KEY = "auth_token"
    }

    private var lazyPrefs: SharedPreferences? = prefs

    fun init(context: Context) {
        if (lazyPrefs == null) {
            lazyPrefs = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        }
    }

    fun getToken(): String? = lazyPrefs?.getString(TOKEN_KEY, null)

    fun saveToken(token: String) {
        lazyPrefs?.edit()?.putString(TOKEN_KEY, token)?.apply()
    }

    fun clearToken() {
        lazyPrefs?.edit()?.remove(TOKEN_KEY)?.apply()
    }

    fun hasToken(): Boolean = getToken() != null
}
