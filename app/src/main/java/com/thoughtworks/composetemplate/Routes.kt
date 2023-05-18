package com.thoughtworks.composetemplate

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thoughtworks.composetemplate.screen.animals.AnimalsScreen
import com.thoughtworks.composetemplate.screen.home.HomeScreen

const val FIRST_SCREEN = Routes.HOME

object Routes {
    const val HOME = "home"
    const val ANIMALS = "animals"
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
            content = @Composable { HomeScreen() },
        )
        composable(
            route = Routes.ANIMALS,
            content = @Composable { AnimalsScreen() },
        )
    }
}
