@file:Suppress("ktlint:standard:filename")

package com.thoughtworks.boilerplate.shared.composequery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch

class UseMutationResult<TData, TParams>(
    val data: TData?,
    val status: QueryStatus,
    val error: Throwable?,
    val mutate: (TParams) -> Unit,
) {
    val isPending: Boolean get() = status == QueryStatus.LOADING
}

@Composable
fun <TData, TParams> useMutation(
    mutationFn: suspend (TParams) -> TData,
    onSuccess: ((TData) -> Unit)? = null,
    onError: ((Throwable) -> Unit)? = null,
): UseMutationResult<TData, TParams> {
    var data by remember { mutableStateOf<TData?>(null) }
    var status by remember { mutableStateOf(QueryStatus.IDLE) }
    var error by remember { mutableStateOf<Throwable?>(null) }
    val scope = rememberCoroutineScope()

    val mutate: (TParams) -> Unit = remember {
        { params: TParams ->
            scope.launch {
                status = QueryStatus.LOADING
                error = null
                try {
                    val result = mutationFn(params)
                    data = result
                    status = QueryStatus.SUCCESS
                    onSuccess?.invoke(result)
                } catch (e: Exception) {
                    status = QueryStatus.ERROR
                    error = e
                    onError?.invoke(e)
                }
            }
        }
    }

    return UseMutationResult(data, status, error, mutate)
}
