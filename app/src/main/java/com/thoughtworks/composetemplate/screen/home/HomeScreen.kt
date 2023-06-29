package com.thoughtworks.composetemplate.screen.home

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.thoughtworks.composetemplate.ui.compose.meta.LocalDevMenu
import com.thoughtworks.composetemplate.ui.compose.scaffold.BaseScaffold
import com.thoughtworks.composetemplate.ui.theme.ComposeTemplateTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val devMenu = LocalDevMenu.current

    devMenu.ScreenContainer {
        BaseScaffold() {
            Greeting(viewModel.name)
        }
    }
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
