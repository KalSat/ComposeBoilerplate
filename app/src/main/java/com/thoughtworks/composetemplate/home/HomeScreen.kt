package com.thoughtworks.composetemplate.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thoughtworks.composetemplate.common.di.ViewModelEntryPoint
import com.thoughtworks.composetemplate.common.di.rememberViewModel
import com.thoughtworks.composetemplate.ui.theme.ComposeTemplateTheme
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Suppress("unused")
@EntryPoint
@InstallIn(ActivityComponent::class)
interface HomeEntryPoint : ViewModelEntryPoint<HomeViewModel>

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = rememberViewModel()
) {
    Greeting(viewModel.name)
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeTemplateTheme {
        HomeScreen(HomeViewModel())
    }
}
