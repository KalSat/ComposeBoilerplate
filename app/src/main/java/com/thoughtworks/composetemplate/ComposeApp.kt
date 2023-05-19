package com.thoughtworks.composetemplate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.compose.rememberNavController
import com.thoughtworks.composetemplate.common.di.NavControllerProvider
import com.thoughtworks.composetemplate.ui.compose.meta.LocalNavController
import com.thoughtworks.composetemplate.ui.theme.ComposeTemplateTheme

@Composable
fun ComposeApp(
    firstScreen: String,
    navControllerProvider: NavControllerProvider,
) {
    ComposeTemplateTheme {
        val navController = rememberNavController()

        DisposableEffect(navController) {
            navControllerProvider.set(navController)
            onDispose {
                navControllerProvider.reset()
            }
        }

        CompositionLocalProvider(
            LocalNavController provides navController,
        ) {
            NavigationGraph(
                navHostController = navController,
                startDestination = firstScreen,
            )
        }
    }
}
