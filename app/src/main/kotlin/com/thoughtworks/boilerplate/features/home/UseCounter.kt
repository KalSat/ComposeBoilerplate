package com.thoughtworks.boilerplate.features.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import com.thoughtworks.boilerplate.utils.Tuple2
import com.thoughtworks.boilerplate.utils.tupleOf
import kotlin.reflect.KFunction0
import xyz.junerver.compose.hooks.useState

/**
 * @author steve  2026/6/11
 */
@Composable
fun useCounter(): Tuple2<Int, KFunction0<Unit>> {
    var count by useState(0)

    fun increment() {
        count++
    }

    return tupleOf(count, ::increment)
}
