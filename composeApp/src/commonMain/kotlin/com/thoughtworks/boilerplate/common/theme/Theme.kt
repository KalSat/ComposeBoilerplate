package com.thoughtworks.boilerplate.common.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.thoughtworks.boilerplate.common.utils.LocalColorPalette

@Composable
fun ComposeBoilerplateTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme,
        shapes = AppShapes,
        typography = AppTypography,
    ) {
        CompositionLocalProvider(
            LocalColorPalette provides AppColorPalette,
        ) {
            content()
        }
    }
}
