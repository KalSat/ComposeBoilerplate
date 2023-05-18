package com.thoughtworks.composetemplate.screen.animals

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import com.thoughtworks.composetemplate.common.asyncLoader.AsyncLoadProcessor
import com.thoughtworks.composetemplate.common.asyncLoader.AutoLoadViewModel

@Composable
fun AnimalsScreen(
    animalsViewModel: AnimalsViewModel = hiltViewModel(),
) {
    AsyncLoadProcessor(
        remember { AutoLoadViewModel(animalsViewModel) }
    ) {
        AnimalsContent(animalsViewModel)
    }
}

@Composable
fun AnimalsContent(
    viewModel: AnimalsViewModel,
) {
}