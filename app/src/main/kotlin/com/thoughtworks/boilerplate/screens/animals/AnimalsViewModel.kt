package com.thoughtworks.boilerplate.screens.animals

import com.thoughtworks.boilerplate.common.asyncLoader.DataViewModel
import com.thoughtworks.boilerplate.data.model.Animal

class AnimalsViewModel(
    private val repository: AnimalRepository = AnimalRepository(),
) : DataViewModel<List<Animal>>() {

    override suspend fun fetch(): List<Animal> {
        return repository.getAnimals()
    }
}
