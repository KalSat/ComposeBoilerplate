package com.thoughtworks.composetemplate.debug

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thoughtworks.composetemplate.common.devmenu.DevMenu
import com.thoughtworks.composetemplate.debug.screen.TestScreen
import com.thoughtworks.composetemplate.ui.theme.ComposeTemplateTheme

object DevMenuRoutes {
    const val TEST = "test"
}

@Suppress("unused")
@OptIn(ExperimentalMaterial3Api::class)
class RealDevMenu : DevMenu {

    @Composable
    override fun ScreenContainer(content: @Composable () -> Unit) {
        ModalNavigationDrawer(
            drawerContent = {
                ComposeTemplateTheme {
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
