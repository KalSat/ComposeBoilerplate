package com.thoughtworks.composetemplate.ui.compose.meta

import android.app.Activity
import androidx.compose.runtime.staticCompositionLocalOf
import com.thoughtworks.composetemplate.BuildConfig
import com.thoughtworks.composetemplate.common.devmenu.DevMenu
import com.thoughtworks.composetemplate.common.devmenu.dummyDevMenu
import com.thoughtworks.composetemplate.common.di.dummyNavController
import com.thoughtworks.composetemplate.ui.theme.AppColorPalette
import kotlin.properties.Delegates

val LocalNavController = staticCompositionLocalOf { dummyNavController }

private val dummyActivity by Delegates.notNull<Activity>()
val LocalActivity = staticCompositionLocalOf { dummyActivity }

val LocalColorPalette = staticCompositionLocalOf { AppColorPalette }

val LocalDevMenu = staticCompositionLocalOf {
    if (BuildConfig.ADD_DEV_MENU) {
        try {
            Class.forName("${BuildConfig.APPLICATION_ID}.debug.RealDevMenu")
                .newInstance() as DevMenu
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
