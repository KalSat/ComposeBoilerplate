package com.thoughtworks.boilerplate.screens.animals

import com.thoughtworks.boilerplate.data.model.Animal
import com.thoughtworks.boilerplate.data.network.animalApi.getCats
import com.thoughtworks.boilerplate.data.network.animalApi.getDogs
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class AnimalRepository(
    private val doGetCats: suspend () -> List<Animal> = { getCats() },
    private val doGetDogs: suspend () -> List<Animal> = { getDogs() },
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    suspend fun getCats() = withContext(dispatcher) {
        doGetCats()
    }

    suspend fun getDogs() = withContext(dispatcher) {
        doGetDogs()
    }

    suspend fun getAnimals() = withContext(dispatcher) {
        val cats = getCats()
        val dogs = getDogs()
        (cats.subList(0, cats.size - 1) + dogs.subList(0, dogs.size - 1)).shuffled()
    }
}
