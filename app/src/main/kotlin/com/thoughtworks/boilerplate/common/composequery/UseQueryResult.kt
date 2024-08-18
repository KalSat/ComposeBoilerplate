package com.thoughtworks.boilerplate.common.composequery

data class UseQueryResult<TData>(
    val data: TData?,
    val state: QueryStatus,
    val error: Throwable?,
)