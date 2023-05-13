package com.thoughtworks.composetemplate.common.di

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.thoughtworks.composetemplate.ui.compose.meta.LocalActivity
import dagger.hilt.android.EntryPointAccessors

interface ViewModelEntryPoint<VM : ViewModel> {
    fun get(): VM
}

@Composable
inline fun <reified EP : ViewModelEntryPoint<T>, T> rememberViewModel(): T {
    val activity = LocalActivity.current
    return remember {
        EntryPointAccessors.fromActivity(activity, EP::class.java).get()
    }
}

