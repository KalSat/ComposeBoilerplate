package com.thoughtworks.composetemplate.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class ColorShades(
    val darkest: Color,
    val dark80: Color,
    val dark60: Color,
    val dark40: Color,
    val dark20: Color,
    val base: Color,
    val light20: Color,
    val light40: Color,
    val light60: Color,
    val light80: Color,
    val lightest: Color,
)

@Immutable
data class ColorPalette(
    val Primary: ColorShades,
    val Secondary: ColorShades,
    val Tertiary: ColorShades,
    val Neutral: ColorShades,
    val Error: ColorShades,
    val Success: ColorShades,
)

private val primary = ColorShades(
    darkest = Color(0xFF00295d),
    dark80 = Color(0xFF003271),
    dark60 = Color(0xFF004294),
    dark40 = Color(0xFF0051B5),
    dark20 = Color(0xFF005DD1),
    base = Color(0xFF006CF2),
    light20 = Color(0xFF3A92FF),
    light40 = Color(0xFF66A6F7),
    light60 = Color(0xFF92C2FF),
    light80 = Color(0xFFCCEEFD),
    lightest = Color(0xFFEEF5FF),
)

private val secondary = ColorShades(
    darkest = Color(0xFF071323),
    dark80 = Color(0xFF08182D),
    dark60 = Color(0xFF0B1B31),
    dark40 = Color(0xFF0E213A),
    dark20 = Color(0xFF0D2443),
    base = Color(0xFF001F45),
    light20 = Color(0xFF173A67),
    light40 = Color(0xFF1F508E),
    light60 = Color(0xFF406DA7),
    light80 = Color(0xFF86A7D2),
    lightest = Color(0xFFCCD9E9),
)

private val tertiary = ColorShades(
    darkest = Color(0xFFFF9900),
    dark80 = Color(0xFFFFA200),
    dark60 = Color(0xFFFFAB05),
    dark40 = Color(0xFFFFBB00),
    dark20 = Color(0xFFFFCC00),
    base = Color(0xFFFFD200),
    light20 = Color(0xFFFFDC3A),
    light40 = Color(0xFFFFE467),
    light60 = Color(0xFFFFEB8F),
    light80 = Color(0xFFFFF0AC),
    lightest = Color(0xFFFFF5C5),
)

private val neutral = ColorShades(
    darkest = Color(0xFF111111),
    dark80 = Color(0xFF1F1F24),
    dark60 = Color(0xFF3E3E41),
    dark40 = Color(0xFF5E5E63),
    dark20 = Color(0xFF8D8D97),
    base = Color(0xFFB4B4BB),
    light20 = Color(0xFFCECED4),
    light40 = Color(0xFFE0E0E6),
    light60 = Color(0xFFF0EFF2),
    light80 = Color(0xFFFCFCFC),
    lightest = Color(0xFFFFFFFF),
)

private val success = ColorShades(
    darkest = Color(0xFF006600),
    dark80 = Color(0xFF007A00),
    dark60 = Color(0xFF009900),
    dark40 = Color(0xFF00B300),
    dark20 = Color(0xFF00CC00),
    base = Color(0xFF00E600),
    light20 = Color(0xFF33FF33),
    light40 = Color(0xFF66FF66),
    light60 = Color(0xFF99FF99),
    light80 = Color(0xFFCCFFCC),
    lightest = Color(0xFFE5FFE5),
)

private val error = ColorShades(
    darkest = Color(0xFF702126),
    dark80 = Color(0xFF8C2B2B),
    dark60 = Color(0xFFA62F2F),
    dark40 = Color(0xFFC03333),
    dark20 = Color(0xFFD33636),
    base = Color(0xFFE63A3A),
    light20 = Color(0xFFF05A5A),
    light40 = Color(0xFFF37A7A),
    light60 = Color(0xFFF69A9A),
    light80 = Color(0xFFF9BABA),
    lightest = Color(0xFFFCDCDC),
)

val LightColorScheme = lightColorScheme(
    primary = primary.base,
    onPrimary = neutral.light80,
    primaryContainer = primary.light80,
    onPrimaryContainer = neutral.darkest,
    inversePrimary = primary.darkest,
    secondary = secondary.base,
    onSecondary = neutral.lightest,
    secondaryContainer = secondary.light80,
    onSecondaryContainer = neutral.darkest,
    tertiary = tertiary.base,
    onTertiary = neutral.lightest,
    tertiaryContainer = tertiary.light80,
    onTertiaryContainer = neutral.darkest,
    background = neutral.lightest,
    onBackground = neutral.darkest,
    surface = neutral.light60,
    onSurface = neutral.darkest,
    surfaceVariant = neutral.light20,
    onSurfaceVariant = neutral.dark40,
    surfaceTint = neutral.light20,
    inverseSurface = neutral.dark60,
    inverseOnSurface = neutral.lightest,
    error = error.base,
    onError = neutral.lightest,
    errorContainer = error.lightest,
    onErrorContainer = neutral.dark80,
    outline = neutral.base,
    outlineVariant = neutral.light40,
    scrim = neutral.dark80,
)

val DarkColorScheme = darkColorScheme()

val AppColorPalette = ColorPalette(
    primary,
    secondary,
    tertiary,
    neutral,
    error,
    success,
)
