package com.thoughtworks.boilerplate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController
import com.thoughtworks.boilerplate.common.navigation.NavigationGraph
import com.thoughtworks.boilerplate.common.theme.ComposeBoilerplateTheme
import com.thoughtworks.boilerplate.common.utils.LocalNavController

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
