package com.thoughtworks.boilerplate.common.asyncLoader

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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import com.thoughtworks.boilerplate.R
import com.thoughtworks.boilerplate.common.theme.EdgeInset
import com.thoughtworks.boilerplate.common.theme.Size

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

@Composable
fun ErrorPlaceholder(
    modifier: Modifier = Modifier,
    errorType: ErrorType = ErrorType.LOADING_OR_PARSING,
    onRetry: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(horizontal = EdgeInset.M),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            modifier = Modifier.size(Size.Giant),
            painter = painterResource(id = errorType.imgId),
            contentDescription = stringResource(id = errorType.title),
            alignment = Alignment.Center,
            contentScale = ContentScale.FillBounds,
        )

        Spacer(modifier = Modifier.height(EdgeInset.M))

        Text(
            text = stringResource(id = errorType.title),
            style = MaterialTheme.typography.titleSmall,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(EdgeInset.XXS))

        Text(
            text = stringResource(id = errorType.subTitle),
            style = MaterialTheme.typography.labelMedium,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.onBackground
        )

        Spacer(modifier = Modifier.height(EdgeInset.L))

        Button(
            onClick = onRetry
        ) {
            Text(text = stringResource(R.string.retry))
        }
    }
}
