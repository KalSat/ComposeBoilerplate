package com.thoughtworks.composetemplate.common.asyncLoader

import androidx.lifecycle.ViewModel

abstract class DataViewModel<T : Any> : ViewModel() {
    lateinit var data: T

    abstract suspend fun fetch(): T
}
