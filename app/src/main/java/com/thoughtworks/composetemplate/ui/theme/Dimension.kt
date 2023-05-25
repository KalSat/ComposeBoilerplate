@file:Suppress("unused")

package com.thoughtworks.composetemplate.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.dp

@Immutable
object Size {

    @Stable
    val XXS = 16.dp

    @Stable
    val XS = 24.dp

    @Stable
    val S = 32.dp

    @Stable
    val M = 40.dp

    @Stable
    val L = 48.dp

    @Stable
    val XL = 64.dp

    @Stable
    val XXL = 80.dp

    @Stable
    val XXXL = 120.dp

    @Stable
    val Largest = 160.dp

    @Stable
    val Giant = 200.dp
}

@Immutable
object EdgeInset {

    @Stable
    val Smallest = 4.dp

    @Stable
    val XXS = 8.dp

    @Stable
    val XS = 12.dp

    @Stable
    val S = 16.dp

    @Stable
    val M = 24.dp

    @Stable
    val L = 32.dp

    @Stable
    val XL = 40.dp

    @Stable
    val XXL = 48.dp

    @Stable
    val XXXL = 64.dp
}

@Immutable
object BorderWidth {

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
