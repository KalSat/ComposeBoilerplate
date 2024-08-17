package com.thoughtworks.boilerplate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.navigation.compose.rememberNavController
import com.thoughtworks.boilerplate.common.di.NavControllerProvider
import com.thoughtworks.boilerplate.ui.compose.meta.LocalNavController
import com.thoughtworks.boilerplate.ui.theme.ComposeBoilerplateTheme

@Composable
fun ComposeApp(
    firstScreen: String,
    navControllerProvider: NavControllerProvider,
) {
    ComposeBoilerplateTheme {
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
