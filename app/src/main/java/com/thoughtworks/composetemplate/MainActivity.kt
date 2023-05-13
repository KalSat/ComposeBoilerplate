package com.thoughtworks.composetemplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.thoughtworks.composetemplate.common.di.NavControllerProvider
import com.thoughtworks.composetemplate.ui.compose.meta.LocalActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var navControllerProvider: NavControllerProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(
                LocalActivity provides this@MainActivity,
            ) {
                ComposeApp(
                    firstScreen = Routes.HOME,
                    navControllerProvider = navControllerProvider,
                )
            }
        }
    }
}
