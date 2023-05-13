package com.thoughtworks.composetemplate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thoughtworks.composetemplate.home.HomeScreen

object Routes {
    const val HOME = "home"
}

@Composable
fun NavigationGraph(
    navHostController: NavHostController,
    startDestination: String,
) {
    NavHost(
        navController = navHostController,
        startDestination = startDestination
    ) {
        composable(
            route = Routes.HOME,
            content = @Composable {
                HomeScreen()
            }
        )
    }
}
