package com.thoughtworks.boilerplate

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.thoughtworks.boilerplate.features.animals.AnimalsScreen
import com.thoughtworks.boilerplate.features.auth.AuthScreen
import com.thoughtworks.boilerplate.features.home.HomeScreen
import com.thoughtworks.boilerplate.states.sAuthState
import com.thoughtworks.boilerplate.utils.LocalDevMenu

const val FIRST_SCREEN = Routes.HOME

object Routes {
    const val LOGIN = "login"
    const val HOME = "home"
    const val ANIMALS = "animals"
}

@Composable
fun NavigationGraph(navHostController: NavHostController, startDestination: String) {
    val devMenu = LocalDevMenu.current
    val isLoggedIn = sAuthState.isLoggedIn

    LaunchedEffect(isLoggedIn) {
        if (!isLoggedIn) {
            navHostController.navigate(Routes.LOGIN) {
                popUpTo(0) { inclusive = true }
            }
        } else if (navHostController.currentDestination?.route == Routes.LOGIN) {
            navHostController.navigate(FIRST_SCREEN) {
                popUpTo(Routes.LOGIN) { inclusive = true }
            }
        }
    }

    val effectiveStart = if (isLoggedIn) startDestination else Routes.LOGIN

    NavHost(
        navController = navHostController,
        startDestination = effectiveStart,
    ) {
        composable(
            route = Routes.LOGIN,
            content = @Composable { AuthScreen() },
        )
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
