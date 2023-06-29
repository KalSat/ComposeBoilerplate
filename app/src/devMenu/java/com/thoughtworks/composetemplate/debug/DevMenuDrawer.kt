package com.thoughtworks.composetemplate.debug

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import com.thoughtworks.composetemplate.BuildConfig
import com.thoughtworks.composetemplate.Routes
import com.thoughtworks.composetemplate.ui.compose.meta.LocalNavController
import com.thoughtworks.composetemplate.ui.theme.EdgeInset
import com.thoughtworks.composetemplate.ui.theme.FontSize

@Composable
fun DevMenuDrawer() {
    if (!BuildConfig.DEBUG) return

    val navController = LocalNavController.current

    Column(
        modifier = Modifier
            .fillMaxWidth(0.66f)
            .fillMaxHeight()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(EdgeInset.M)
            .verticalScroll(rememberScrollState())
    ) {
        Text(
            text = "Dev Menu",
            fontWeight = FontWeight.Bold,
            fontSize = FontSize.L,
        )

        Spacer(modifier = Modifier.height(EdgeInset.L))

        TextButton(onClick = { navController.navigate(Routes.ANIMALS) }) {
            Text(text = "Animal", fontSize = FontSize.S)
        }
    }
}
