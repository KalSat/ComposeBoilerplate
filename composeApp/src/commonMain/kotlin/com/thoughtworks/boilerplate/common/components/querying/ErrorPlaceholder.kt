package com.thoughtworks.boilerplate.common.components.querying

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import com.thoughtworks.boilerplate.common.theme.EdgeInset
import com.thoughtworks.boilerplate.common.theme.Size
import composeboilerplate.composeapp.generated.resources.Res
import composeboilerplate.composeapp.generated.resources.connection_error_subtitle
import composeboilerplate.composeapp.generated.resources.connection_error_title
import composeboilerplate.composeapp.generated.resources.empty_network_error
import composeboilerplate.composeapp.generated.resources.empty_no_network
import composeboilerplate.composeapp.generated.resources.parse_and_loading_error_subtitle
import composeboilerplate.composeapp.generated.resources.parse_and_loading_error_title
import composeboilerplate.composeapp.generated.resources.retry
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.resources.stringResource

enum class ErrorType(
    val title: StringResource,
    val subTitle: StringResource,
    val imgId: DrawableResource,

    ) {
    LOADING_OR_PARSING(
        title = Res.string.parse_and_loading_error_title,
        subTitle = Res.string.parse_and_loading_error_subtitle,
        imgId = Res.drawable.empty_network_error
    ),
    INTERNET(
        title = Res.string.connection_error_title,
        subTitle = Res.string.connection_error_subtitle,
        imgId = Res.drawable.empty_no_network
    )
}

@Composable
fun ErrorPlaceholder(
    modifier: Modifier = Modifier,
    errorType: ErrorType = ErrorType.LOADING_OR_PARSING,
    onRetry: () -> Unit,
) {
    Column(
        modifier = modifier
            .padding(horizontal = EdgeInset.M),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(Size.Giant),
            painter = painterResource(errorType.imgId),
            contentDescription = stringResource(errorType.title),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds,
        )

        Spacer(modifier = Modifier.height(EdgeInset.M))

        Text(
            text = stringResource(errorType.title),
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(EdgeInset.XXS))

        Text(
            text = stringResource(errorType.subTitle),
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(EdgeInset.L))

        Button(
            onClick = onRetry
        ) {
            Text(text = stringResource(Res.string.retry))
        }
    }
}
