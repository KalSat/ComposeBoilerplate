@file:Suppress("unused")

package com.thoughtworks.composetemplate.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Immutable
object CornerRadius {

    @Stable
    val XS = 4.dp

    @Stable
    val S = 8.dp

    @Stable
    val M = 16.dp

    @Stable
    val L = 24.dp

    @Stable
    val XL = 28.dp
}

@Immutable
object BorderShape {

    @Stable
    val None = RectangleShape

    @Stable
    val XS = RoundedCornerShape(CornerRadius.XS)

    @Stable
    val S = RoundedCornerShape(CornerRadius.S)

    @Stable
    val M = RoundedCornerShape(CornerRadius.M)

    @Stable
    val L = RoundedCornerShape(CornerRadius.L)

    @Stable
    val XL = RoundedCornerShape(CornerRadius.XL)

    @Stable
    val Circular = CircleShape
}

val AppShapes = Shapes(
    extraSmall = BorderShape.XS,
    small = BorderShape.S,
    medium = BorderShape.M,
    large = BorderShape.L,
    extraLarge = BorderShape.XL,
)
