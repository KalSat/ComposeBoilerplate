package com.thoughtworks.composetemplate.common.asyncLoader

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.thoughtworks.composetemplate.R
import com.thoughtworks.composetemplate.ui.theme.Spacing

enum class ErrorType(
    val title: Int,
    val subTitle: Int,
    val imgId: Int

) {
    LOADING_OR_PARSING(
        title = R.string.parse_and_loading_error_title,
        subTitle = R.string.parse_and_loading_error_subtitle,
        imgId = R.drawable.empty_network_error
    ),
    INTERNET(
        title = R.string.connection_error_title,
        subTitle = R.string.connection_error_subtitle,
        imgId = R.drawable.empty_no_network
    )
}

val PLACEHOLDER_IMAGE_SIZE = 180.dp

@Composable
fun ErrorPlaceholder(
    modifier: Modifier = Modifier,
    errorType: ErrorType = ErrorType.LOADING_OR_PARSING,
    onRetry: () -> Unit
) {
    Column(
        modifier = modifier
            .background(MaterialTheme.colorScheme.surface)
            .padding(horizontal = Spacing.XS),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(PLACEHOLDER_IMAGE_SIZE),
            painter = painterResource(id = errorType.imgId),
            contentDescription = stringResource(id = errorType.title),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds,
        )
        Text(
            modifier = Modifier.padding(top = Spacing.XS),
            text = stringResource(id = errorType.title),
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )
        Text(
            modifier = Modifier.padding(top = Spacing.XXXS, bottom = Spacing.S),
            text = stringResource(id = errorType.subTitle),
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onSurface
        )
        Button(
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme.colorScheme.primary,
            ),
            onClick = onRetry
        ) {
            Text(
                text = stringResource(R.string.retry),
//                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}
