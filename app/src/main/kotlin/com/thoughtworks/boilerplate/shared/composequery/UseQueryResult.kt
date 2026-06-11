package com.thoughtworks.boilerplate.shared.composequery

data class UseQueryResult<TData>(val data: TData?, val state: QueryStatus, val error: Throwable?)
