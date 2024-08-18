package com.thoughtworks.boilerplate

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import com.thoughtworks.boilerplate.common.navigation.FIRST_SCREEN
import com.thoughtworks.boilerplate.common.utils.LocalActivity

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CompositionLocalProvider(
                LocalActivity provides this@MainActivity,
            ) {
                ComposeApp(
                    firstScreen = FIRST_SCREEN,
                )
            }
        }
    }
}
