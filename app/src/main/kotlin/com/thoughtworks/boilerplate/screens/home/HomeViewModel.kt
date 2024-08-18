package com.thoughtworks.boilerplate.screens.home

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    var name by mutableStateOf("Android")
}
