package com.thoughtworks.composetemplate.common.asyncLoader

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thoughtworks.composetemplate.R
import com.thoughtworks.composetemplate.ui.theme.Spacing

private val LOADING_IMAGE_SIZE = 66.dp

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
        CircularProgressIndicator(
            modifier = Modifier
                .size(LOADING_IMAGE_SIZE)
        )

        Spacer(modifier = Modifier.height(Spacing.XXS))

        Text(text = stringResource(R.string.loading))
    }
}
