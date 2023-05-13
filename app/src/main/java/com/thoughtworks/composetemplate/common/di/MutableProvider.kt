package com.thoughtworks.composetemplate.common.di

import javax.inject.Provider
import kotlin.coroutines.Continuation
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

open class MutableProvider<T>(private val initialValue: T) : Provider<T> {
    private var current: T = initialValue
    private var continuation: Continuation<T>? = null

    override fun get(): T = current

    suspend fun getSync(): T = suspendCoroutine {
        if (current != initialValue) {
            it.resume(current)
        } else {
            continuation = it
        }
    }

    fun set(newVal: T) {
        current = newVal
        continuation?.resume(current)
    }

    fun reset() {
        current = initialValue
    }
}
