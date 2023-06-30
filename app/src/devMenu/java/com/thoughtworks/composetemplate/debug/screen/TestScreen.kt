package com.thoughtworks.composetemplate.debug.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.thoughtworks.composetemplate.ui.compose.scaffold.BaseScaffold
import com.thoughtworks.composetemplate.ui.theme.FontSize

@OptIn(ExperimentalMaterial3Api::class)
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
