package com.thoughtworks.boilerplate.common.components.querying

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.thoughtworks.boilerplate.R
import com.thoughtworks.boilerplate.common.composequery.QueryStatus
import com.thoughtworks.boilerplate.common.composequery.UseQueryResult
import java.net.ConnectException
import java.net.UnknownHostException

@Composable
fun <TData> QueryWrapper(
    result: UseQueryResult<TData>,
    showLoadingInReload: Boolean = true,
    loadingView: @Composable () -> Unit = { LoadingPlaceholder() },
    errorView: @Composable (Throwable) -> Unit = { err ->
        ErrorPlaceholder(
            modifier = Modifier.fillMaxSize(),
            errorType = when (err) {
                is ConnectException, is UnknownHostException -> ErrorType.INTERNET
                else -> ErrorType.LOADING_OR_PARSING
            },
            onRetry = { /* TODO */ },
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
    contentView: @Composable (data: TData) -> Unit
) {
    val (data, state, error) = result
    when (state) {
        QueryStatus.IDLE -> {
            if (data != null) {
                contentView(data)
            }
        }

        QueryStatus.LOADING -> {
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

        QueryStatus.SUCCESS -> {
            contentView(data!!)
        }

        QueryStatus.ERROR -> {
            if (data == null) {
                errorView(error!!)
            } else {
                contentView(data)
                errorAlert.invoke(error!!)
            }
        }
    }

}