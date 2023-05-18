package com.thoughtworks.composetemplate.screen.animals

import com.thoughtworks.composetemplate.common.asyncLoader.DataViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimalsViewModel @Inject constructor() : DataViewModel<Any>() {

    override suspend fun fetch(): Any {
        return Any()
    }
}