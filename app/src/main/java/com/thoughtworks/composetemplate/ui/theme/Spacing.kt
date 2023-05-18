package com.thoughtworks.composetemplate.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.unit.dp


@Suppress("unused")
@Immutable
class Spacing {
    companion object {
        @Stable
        val Smallest = 4.dp

        @Stable
        val XXXS = 8.dp

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
}
