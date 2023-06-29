package com.thoughtworks.composetemplate.common.devmenu

import androidx.compose.runtime.Composable

class DummyDevMenu : DevMenu {
    @Composable
    override fun ScreenContainer(content: @Composable () -> Unit) = content()
}

val dummyDevMenu = DummyDevMenu()
