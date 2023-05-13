package com.thoughtworks.composetemplate

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.DisposableEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
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
        val scaffoldState = rememberScaffoldState()

        val focusManager = LocalFocusManager.current

        DisposableEffect(navController) {
            navControllerProvider.set(navController)
            onDispose {
                navControllerProvider.reset()
            }
        }

        CompositionLocalProvider(
            LocalNavController provides navController,
        ) {
            Scaffold(
                modifier = Modifier
                    .pointerInput(Unit) {
                        detectTapGestures(onTap = {
                            focusManager.clearFocus()
                        })
                    },
                scaffoldState = scaffoldState,
                topBar = {
                    TopAppBar {
                        Text(text = "Compose Template")
                    }
                },
            ) { paddingValues ->
                Box(
                    modifier = Modifier.padding(paddingValues = paddingValues)
                ) {
                    NavigationGraph(
                        navHostController = navController,
                        startDestination = firstScreen,
                    )
                }
            }
        }
    }
}
