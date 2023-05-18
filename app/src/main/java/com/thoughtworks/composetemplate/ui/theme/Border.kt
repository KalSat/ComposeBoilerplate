@file:Suppress("unused")

package com.thoughtworks.composetemplate.ui.theme

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp

@Immutable
class BorderWidth {
    companion object {

        @Stable
        val None = 0.dp

        @Stable
        val Thin = 0.5.dp

        @Stable
        val Light = 1.dp

        @Stable
        val Regular = 2.dp

        @Stable
        val Medium = 4.dp

        @Stable
        val Heavy = 8.dp
    }
}

@Immutable
class BorderRadius {
    companion object {

        @Stable
        val XS = 4.dp

        @Stable
        val S = 8.dp

        @Stable
        val M = 16.dp

        @Stable
        val L = 24.dp
    }
}

@Immutable
class BorderShape {
    companion object {

        @Stable
        val None = RectangleShape

        @Stable
        val XS = RoundedCornerShape(BorderRadius.XS)

        @Stable
        val S = RoundedCornerShape(BorderRadius.S)

        @Stable
        val M = RoundedCornerShape(BorderRadius.M)

        @Stable
        val L = RoundedCornerShape(BorderRadius.L)

        @Stable
        val Circular = CircleShape
    }
}
