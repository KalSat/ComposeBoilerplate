package com.thoughtworks.boilerplate.common.components.querying

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.thoughtworks.boilerplate.common.theme.EdgeInset
import com.thoughtworks.boilerplate.common.theme.Size
import composeboilerplate.composeapp.generated.resources.Res
import composeboilerplate.composeapp.generated.resources.loading
import org.jetbrains.compose.resources.stringResource

@Composable
fun LoadingPlaceholder(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.surface)
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(modifier = Modifier.size(Size.XL))

        Spacer(modifier = Modifier.height(EdgeInset.S))

        Text(
            text = stringResource(Res.string.loading),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}
