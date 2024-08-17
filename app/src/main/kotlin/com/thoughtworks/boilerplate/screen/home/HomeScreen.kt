package com.thoughtworks.boilerplate.screen.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.thoughtworks.boilerplate.ui.compose.meta.LocalDevMenu
import com.thoughtworks.boilerplate.ui.compose.scaffold.BaseScaffold
import com.thoughtworks.boilerplate.ui.theme.ComposeBoilerplateTheme

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
    ComposeBoilerplateTheme {
        HomeScreen(HomeViewModel())
    }
}
