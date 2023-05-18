package com.thoughtworks.composetemplate.screen.animals

import com.thoughtworks.composetemplate.common.asyncLoader.DataViewModel
import com.thoughtworks.composetemplate.common.network.animal.model.Animal
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimalsViewModel @Inject constructor(
    private val repository: AnimalRepository
) : DataViewModel<List<Animal>>() {

    override suspend fun fetch(): List<Animal> {
        return repository.getAnimals()
    }
}
