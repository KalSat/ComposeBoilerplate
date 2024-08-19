package com.thoughtworks.boilerplate.common.utils

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController
import com.thoughtworks.boilerplate.common.devmenu.dummyDevMenu
import com.thoughtworks.boilerplate.common.theme.AppColorPalette
import kotlin.properties.Delegates

private val dummyNavController by Delegates.notNull<NavController>()
val LocalNavController = staticCompositionLocalOf { dummyNavController }

val LocalColorPalette = staticCompositionLocalOf { AppColorPalette }

val LocalDevMenu = staticCompositionLocalOf { dummyDevMenu }
//    if (BuildConfig.ADD_DEV_MENU) {
//        try {
//            Class.forName("${BuildConfig.APPLICATION_ID}.debug.RealDevMenu")
//                .getDeclaredConstructor().newInstance() as DevMenu
//        } catch (e: Throwable) {
//            if (BuildConfig.DEBUG) {
//                throw e
//            } else {
//                dummyDevMenu
//            }
//        }
//    } else {
//        dummyDevMenu
//    }
//}
