package com.thoughtworks.composetemplate.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(
) : ViewModel() {
    var name by mutableStateOf("Android")
}
