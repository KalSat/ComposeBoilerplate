package com.thoughtworks.boilerplate.common.asyncLoader

open class AutoLoadViewModel<T : Any> constructor(
    dataViewModel: DataViewModel<T>,
) : AsyncLoadViewModel<T>(dataViewModel) {
    init {
        load()
    }
}
