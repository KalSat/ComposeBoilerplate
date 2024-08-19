package com.thoughtworks.boilerplate.common.devmenu

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder

interface DevMenu {
    @Composable
    fun ScreenContainer(content: @Composable () -> Unit)
    fun NavGraphBuilder.builder()

    val navGraphBuilder: NavGraphBuilder.() -> Unit
        get() = { builder() }
}
