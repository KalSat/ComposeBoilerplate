package com.thoughtworks.boilerplate.screens.animals

import com.thoughtworks.boilerplate.data.network.animalApi.getCats
import com.thoughtworks.boilerplate.data.network.animalApi.getDogs
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

class AnimalRepository(
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    suspend fun fetchCats() = withContext(dispatcher) {
        getCats()
    }

    suspend fun fetchDogs() = withContext(dispatcher) {
        getDogs()
    }

    suspend fun getAnimals() = withContext(dispatcher) {
        val cats = fetchCats()
        val dogs = fetchDogs()
        (cats.subList(0, cats.size - 1) + dogs.subList(0, dogs.size - 1)).shuffled()
    }
}
