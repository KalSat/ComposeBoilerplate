package com.thoughtworks.boilerplate

import android.app.Application
import com.thoughtworks.boilerplate.shared.sTokenStore
import com.thoughtworks.boilerplate.states.sAuthState

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        sTokenStore.init(applicationContext)
        sAuthState.init()
    }
}
