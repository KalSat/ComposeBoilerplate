package com.thoughtworks.composetemplate.common.asyncLoader

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class AsyncLoadViewModel<T : Any> constructor(
    var dataViewModel: DataViewModel<T>,
) : ViewModel() {
    private val idle = LoadState.Idle<T>()

    var loadState: LoadState<T> = idle
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
                Log.e("AsyncLoadViewModel", "there is an error in fetcher", e)
                loadState = LoadState.Failure(data, e)
            }
        }
    }

    fun reset() {
        loadState = idle
        data = null
    }

}
