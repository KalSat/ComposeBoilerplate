package com.thoughtworks.boilerplate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import com.thoughtworks.boilerplate.ui.compose.meta.LocalNavController
import com.thoughtworks.boilerplate.ui.theme.ComposeBoilerplateTheme

@Composable
fun ComposeApp(
    firstScreen: String,
) {
    ComposeBoilerplateTheme {
        val navController = rememberNavController()

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
