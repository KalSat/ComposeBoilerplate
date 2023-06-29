package com.thoughtworks.composetemplate.debug

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import com.thoughtworks.composetemplate.common.devmenu.DevMenu
import com.thoughtworks.composetemplate.ui.theme.ComposeTemplateTheme

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
}
