package com.thoughtworks.boilerplate.common.composequery

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

@Composable
fun <TData> useQuery(
    queryKeys: Array<String>,
    queryFn: suspend () -> TData,
): UseQueryResult<TData> {
    var data by remember { mutableStateOf<TData?>(null) }
    var state by remember { mutableStateOf(QueryStatus.IDLE) }
    var error by remember { mutableStateOf<Throwable?>(null) }

    LaunchedEffect(Unit) {
        state = QueryStatus.LOADING
        try {
            data = queryFn()
            state = QueryStatus.SUCCESS
        } catch (e: Exception) {
            state = QueryStatus.ERROR
            error = e
        }
    }

    return UseQueryResult(data, state, error)
}