package com.thoughtworks.composetemplate.common.asyncLoader

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thoughtworks.composetemplate.R
import java.net.ConnectException
import java.net.UnknownHostException

/**
 * This component provides API to put together the components required to display a loading operation.
 * When [LoadState.Loading], the component will display a loading indicator page.
 * When [LoadState.Success], the component will render the component provided by [contentView].
 * When [LoadState.Failure], the component will display an error page.
 *
 * @param asyncLoadViewModel View model that processing loading status.
 * @param contentView The content to display when loading is successful, will provide the data view model.
 * @param loadingView Loading component to use when loading is in progress.
 * @param errorView Error component to use when loading resulted as error.
 */
@Composable
fun <T : Any> AsyncLoadProcessor(
    asyncLoadViewModel: AsyncLoadViewModel<T>,
    showLoadingInReload: Boolean = true,
    loadingView: @Composable () -> Unit = { LoadingPlaceholder() },
    errorView: @Composable (Throwable) -> Unit = { err ->
        ErrorPlaceholder(
            modifier = Modifier.fillMaxSize(),
            errorType = when (err) {
                is ConnectException, is UnknownHostException -> ErrorType.INTERNET
                else -> ErrorType.LOADING_OR_PARSING
            },
            onRetry = { asyncLoadViewModel.load() },
        )
    },
    errorAlert: (@Composable (Throwable) -> Unit) = { err ->
        Snackbar(
            modifier = Modifier.padding(8.dp)
        ) {
            Text(
                stringResource(
                    when (err) {
                        is ConnectException, is UnknownHostException -> R.string.connection_error_subtitle
                        else -> R.string.parse_and_loading_error_subtitle
                    }
                )
            )
        }
    },
    contentView: @Composable (data: T) -> Unit,
) {
    when (val loadState = asyncLoadViewModel.loadState) {
        is LoadState.Loading -> {
            val data = loadState.data
            if (data == null) {
                loadingView()
            } else { // reload
                if (showLoadingInReload) {
                    loadingView()
                } else {
                    contentView(data)
                }
            }
        }

        is LoadState.Success -> {
            contentView(loadState.data)
        }

        is LoadState.Failure -> {
            val data = loadState.data
            if (data == null) {
                errorView(loadState.error)
            } else {
                contentView(data)
                errorAlert.invoke(loadState.error)
            }
        }

        else -> {}
    }
}

@Composable
fun <T : Any> AsyncLoadSkeleton(
    asyncLoadViewModel: AsyncLoadViewModel<T>,
    showLoadingInReload: Boolean = false,
    skeletonView: @Composable () -> Unit,
    errorAlert: (@Composable (Throwable) -> Unit)?,
    contentView: @Composable (data: T) -> Unit,
) {
    when (val loadState = asyncLoadViewModel.loadState) {
        is LoadState.Loading -> {
            val data = loadState.data
            if (data == null) {
                skeletonView()
            } else { // reload
                if (showLoadingInReload) {
                    skeletonView()
                } else {
                    contentView(data)
                }
            }
        }

        is LoadState.Success -> {
            contentView(loadState.data)
        }

        is LoadState.Failure -> {
            val data = loadState.data
            if (data == null) {
                skeletonView()
            } else {
                contentView(data)
            }
            errorAlert?.invoke(loadState.error)
        }

        else -> {
            skeletonView()
        }
    }
}
