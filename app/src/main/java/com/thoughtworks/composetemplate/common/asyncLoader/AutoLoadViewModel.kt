package com.thoughtworks.composetemplate.common.asyncLoader

open class AutoLoadViewModel<T : Any> constructor(
    dataViewModel: DataViewModel<T>,
) : AsyncLoadViewModel<T>(dataViewModel) {
    init {
        load()
    }
}
