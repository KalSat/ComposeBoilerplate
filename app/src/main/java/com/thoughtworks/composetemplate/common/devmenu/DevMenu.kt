package com.thoughtworks.composetemplate.common.devmenu

import androidx.compose.runtime.Composable

interface DevMenu {
    @Composable
    fun ScreenContainer(content: @Composable () -> Unit)
}
