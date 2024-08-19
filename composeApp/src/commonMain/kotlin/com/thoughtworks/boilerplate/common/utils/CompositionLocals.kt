package com.thoughtworks.boilerplate.common.utils

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController
import com.thoughtworks.boilerplate.common.devmenu.dummyDevMenu
import com.thoughtworks.boilerplate.common.theme.AppColorPalette
import com.thoughtworks.boilerplate.debug.RealDevMenu
import kotlin.properties.Delegates

private val dummyNavController by Delegates.notNull<NavController>()
val LocalNavController = staticCompositionLocalOf { dummyNavController }

val LocalColorPalette = staticCompositionLocalOf { AppColorPalette }

const val ADD_DEV_MENU = true
val LocalDevMenu = staticCompositionLocalOf {
    if (ADD_DEV_MENU) {
        RealDevMenu()
    } else {
        dummyDevMenu
    }
}
