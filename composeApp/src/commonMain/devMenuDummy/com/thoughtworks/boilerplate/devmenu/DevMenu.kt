package com.thoughtworks.boilerplate.devmenu

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder

@Composable
fun DevMenuDrawerContainer(content: @Composable () -> Unit) = content()

fun NavGraphBuilder.devMenuNavGraphBuilder() = Unit
