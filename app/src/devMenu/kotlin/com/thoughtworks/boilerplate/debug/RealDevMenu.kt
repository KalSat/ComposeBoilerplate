package com.thoughtworks.boilerplate.debug

import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thoughtworks.boilerplate.common.devmenu.DevMenu
import com.thoughtworks.boilerplate.debug.screen.TestScreen
import com.thoughtworks.boilerplate.ui.theme.ComposeBoilerplateTheme

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
            }
        )
    }

    override fun NavGraphBuilder.builder() {
        composable(
            route = DevMenuRoutes.TEST,
            content = @Composable { TestScreen() },
        )
    }
}
