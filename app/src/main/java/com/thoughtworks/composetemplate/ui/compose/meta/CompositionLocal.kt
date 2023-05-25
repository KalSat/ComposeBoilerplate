package com.thoughtworks.composetemplate.ui.compose.meta

import android.app.Activity
import androidx.compose.runtime.staticCompositionLocalOf
import com.thoughtworks.composetemplate.common.di.dummyNavController
import com.thoughtworks.composetemplate.ui.theme.AppColorPalette
import kotlin.properties.Delegates

val LocalNavController = staticCompositionLocalOf { dummyNavController }

private val dummyActivity by Delegates.notNull<Activity>()
val LocalActivity = staticCompositionLocalOf { dummyActivity }

val LocalColorPalette = staticCompositionLocalOf { AppColorPalette }
