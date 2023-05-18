package com.thoughtworks.composetemplate.common.asyncLoader

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import java.io.PrintWriter
import java.io.StringWriter
import kotlinx.coroutines.launch

open class AsyncLoadViewModel<T : Any> constructor(
    var dataViewModel: DataViewModel<T>,
) : ViewModel() {
    private val idle = LoadState.Idle<T>()

    var loadState: LoadState<T> by mutableStateOf(idle)
        protected set
    private var data: T? = null

    fun load() {
        loadState = LoadState.Loading(data)
        viewModelScope.launch {
            try {
                val data = dataViewModel.fetch()
                this@AsyncLoadViewModel.data = data
                dataViewModel.data = data
                loadState = LoadState.Success(data)
            } catch (e: Exception) {
                StringWriter().use { sw ->
                    e.printStackTrace(PrintWriter(sw))
                    Log.e("AsyncLoadViewModel", "there is an error in fetcher\n$sw")
                }
                loadState = LoadState.Failure(data, e)
            }
        }
    }

    fun reset() {
        loadState = idle
        data = null
    }
}
