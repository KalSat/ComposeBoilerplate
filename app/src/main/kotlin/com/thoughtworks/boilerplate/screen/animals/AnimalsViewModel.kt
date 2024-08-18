package com.thoughtworks.boilerplate.screen.animals

import com.thoughtworks.boilerplate.common.asyncLoader.DataViewModel
import com.thoughtworks.boilerplate.common.network.animal.model.Animal

class AnimalsViewModel(
    private val repository: AnimalRepository = AnimalRepository(),
) : DataViewModel<List<Animal>>() {

    override suspend fun fetch(): List<Animal> {
        return repository.getAnimals()
    }
}
