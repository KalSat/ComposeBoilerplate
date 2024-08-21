package com.thoughtworks.boilerplate.common.utils

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavController
import com.thoughtworks.boilerplate.common.theme.AppColorPalette
import kotlin.properties.Delegates

private val dummyNavController by Delegates.notNull<NavController>()
val LocalNavController = staticCompositionLocalOf { dummyNavController }

val LocalColorPalette = staticCompositionLocalOf { AppColorPalette }
