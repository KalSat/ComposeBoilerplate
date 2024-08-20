package com.thoughtworks.boilerplate

import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

fun main() = application {
    val state = rememberWindowState(width = 450.dp, height = 900.dp)

    Window(
        onCloseRequest = ::exitApplication,
        state,
        title = "ComposeBoilerplate",
    ) {

    ComposeApp()
    }
}