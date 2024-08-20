package com.thoughtworks.boilerplate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.compose.rememberNavController
import com.thoughtworks.boilerplate.common.navigation.FIRST_SCREEN
import com.thoughtworks.boilerplate.common.navigation.NavigationGraph
import com.thoughtworks.boilerplate.common.theme.ComposeBoilerplateTheme
import com.thoughtworks.boilerplate.common.utils.LocalNavController
import io.github.aakira.napier.DebugAntilog
import io.github.aakira.napier.Napier

@Composable
fun ComposeApp(
    firstScreen: String = FIRST_SCREEN,
) {
    LaunchedEffect(Unit) {
        // Initialize Napier
        Napier.base(DebugAntilog())
    }

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
