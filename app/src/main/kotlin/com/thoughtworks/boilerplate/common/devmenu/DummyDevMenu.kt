package com.thoughtworks.boilerplate.common.devmenu

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder

class DummyDevMenu : DevMenu {
    @Composable
    override fun ScreenContainer(content: @Composable () -> Unit) = content()

    override fun NavGraphBuilder.builder() = Unit
}

val dummyDevMenu = DummyDevMenu()
