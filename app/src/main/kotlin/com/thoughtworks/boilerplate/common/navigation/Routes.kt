package com.thoughtworks.boilerplate.common.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thoughtworks.boilerplate.BuildConfig
import com.thoughtworks.boilerplate.common.utils.LocalDevMenu
import com.thoughtworks.boilerplate.screens.animals.AnimalsScreen
import com.thoughtworks.boilerplate.screens.home.HomeScreen

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
    val devMenu = LocalDevMenu.current

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

        if (BuildConfig.ADD_DEV_MENU) {
            devMenu.navGraphBuilder(this)
        }
    }
}
