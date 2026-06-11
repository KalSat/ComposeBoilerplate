package com.thoughtworks.boilerplate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import com.thoughtworks.boilerplate.theme.ComposeBoilerplateTheme
import com.thoughtworks.boilerplate.utils.LocalNavController

@Composable
fun ComposeApp(firstScreen: String) {
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
