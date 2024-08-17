package com.thoughtworks.boilerplate.debug.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.thoughtworks.boilerplate.ui.compose.scaffold.BaseScaffold
import com.thoughtworks.boilerplate.ui.theme.FontSize

@Composable
fun TestScreen() {
    BaseScaffold {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(text = "Test Screen", fontSize = FontSize.XL)
        }
    }
}
