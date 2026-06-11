package com.thoughtworks.boilerplate.features.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.thoughtworks.boilerplate.components.scaffold.BaseScaffold
import com.thoughtworks.boilerplate.theme.ComposeBoilerplateTheme
import com.thoughtworks.boilerplate.utils.LocalDevMenu

@Composable
fun HomeScreen() {
    val devMenu = LocalDevMenu.current

    val (count, increment) = useCounter()

    devMenu.ScreenContainer {
        BaseScaffold(
            floatingActionButton = {
                FloatingActionButton(
                    onClick = increment,
                    shape = CircleShape,
                ) {
                    Icon(Icons.Filled.Add, "Floating action button.")
                }
            },
        ) {
            Greeting("$count")
        }
    }
}

@Composable
fun Greeting(count: String, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Hello, you have clicked $count times!",
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    ComposeBoilerplateTheme {
        HomeScreen()
    }
}
