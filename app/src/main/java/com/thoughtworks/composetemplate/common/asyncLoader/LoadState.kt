package com.thoughtworks.composetemplate.common.asyncLoader

sealed class LoadState<T> {

    class Idle<T> : LoadState<T>()

    data class Loading<T>(val data: T?) : LoadState<T>()

    data class LoadingMore<T>(val data: T) : LoadState<T>()

    data class Success<T>(val data: T) : LoadState<T>()

    data class Failure<T>(val data: T?, val error: Throwable) : LoadState<T>()
}
