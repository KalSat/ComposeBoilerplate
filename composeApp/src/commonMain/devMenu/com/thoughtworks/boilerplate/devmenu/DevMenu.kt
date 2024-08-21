package com.thoughtworks.boilerplate.devmenu

import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.thoughtworks.boilerplate.common.theme.ComposeBoilerplateTheme
import com.thoughtworks.boilerplate.devmenu.screens.TestScreen

object DevMenuRoutes {
    const val TEST = "test"
}

@Composable
fun DevMenuDrawerContainer(content: @Composable () -> Unit) {
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

fun NavGraphBuilder.devMenuNavGraphBuilder() {
    composable(
        route = DevMenuRoutes.TEST,
        content = @Composable { TestScreen() },
    )
}