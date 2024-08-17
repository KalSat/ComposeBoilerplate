package com.thoughtworks.boilerplate.ui.compose.meta

import android.app.Activity
import androidx.compose.runtime.staticCompositionLocalOf
import com.thoughtworks.boilerplate.BuildConfig
import com.thoughtworks.boilerplate.common.devmenu.DevMenu
import com.thoughtworks.boilerplate.common.devmenu.dummyDevMenu
import com.thoughtworks.boilerplate.common.di.dummyNavController
import com.thoughtworks.boilerplate.ui.theme.AppColorPalette
import kotlin.properties.Delegates

val LocalNavController = staticCompositionLocalOf { dummyNavController }

private val dummyActivity by Delegates.notNull<Activity>()
val LocalActivity = staticCompositionLocalOf { dummyActivity }

val LocalColorPalette = staticCompositionLocalOf { AppColorPalette }

val LocalDevMenu = staticCompositionLocalOf {
    if (BuildConfig.ADD_DEV_MENU) {
        try {
            Class.forName("${BuildConfig.APPLICATION_ID}.debug.RealDevMenu")
                .getDeclaredConstructor().newInstance() as DevMenu
        } catch (e: Throwable) {
            if (BuildConfig.DEBUG) {
                throw e
            } else {
                dummyDevMenu
            }
        }
    } else {
        dummyDevMenu
    }
}
