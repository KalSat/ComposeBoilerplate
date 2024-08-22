package com.thoughtworks.boilerplate.testutils

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.navigation.NavController
import com.thoughtworks.boilerplate.common.utils.LocalNavController
import io.mockk.mockk

@Composable
fun CompositionProvider(content: @Composable () -> Unit) {
    val navController = remember { mockk<NavController>(relaxed = true) }

    CompositionLocalProvider(
        LocalNavController provides navController,
    ) {
        content()
    }
}
