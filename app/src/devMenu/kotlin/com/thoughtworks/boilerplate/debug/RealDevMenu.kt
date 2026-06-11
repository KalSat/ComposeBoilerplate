package com.thoughtworks.boilerplate.debug

import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thoughtworks.boilerplate.debug.screens.TestScreen
import com.thoughtworks.boilerplate.devmenu.DevMenu
import com.thoughtworks.boilerplate.theme.ComposeBoilerplateTheme

object DevMenuRoutes {
    const val TEST = "test"
}

@Suppress("unused")
class RealDevMenu : DevMenu {

    @Composable
    override fun ScreenContainer(content: @Composable () -> Unit) {
        ModalNavigationDrawer(
            drawerContent = {
                ComposeBoilerplateTheme {
                    DevMenuDrawer()
                }
            },
            content = {
                content()
            },
        )
    }

    override fun NavGraphBuilder.builder() {
        composable(
            route = DevMenuRoutes.TEST,
            content = @Composable { TestScreen() },
        )
    }
}
