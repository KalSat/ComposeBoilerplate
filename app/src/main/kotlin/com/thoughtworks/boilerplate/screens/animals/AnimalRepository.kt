package com.thoughtworks.boilerplate.screens.animals

import com.thoughtworks.boilerplate.data.network.animalApi.CatApi
import com.thoughtworks.boilerplate.data.network.animalApi.DogApi
import com.thoughtworks.boilerplate.data.network.animalApi.sCatApi
import com.thoughtworks.boilerplate.data.network.animalApi.sDogApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AnimalRepository(
    private val catApi: CatApi = sCatApi,
    private val dogApi: DogApi = sDogApi,
    private val dispatcher: CoroutineDispatcher = Dispatchers.IO,
) {

    suspend fun getCats() = withContext(dispatcher) {
        catApi.getCats()
    }

    suspend fun getDogs() = withContext(dispatcher) {
        dogApi.getDogs()
    }

    suspend fun getAnimals() = withContext(dispatcher) {
        val cats = withContext(dispatcher) { getCats() }
        val dogs = withContext(dispatcher) { getDogs() }
        (cats.subList(0, cats.size - 1) + dogs.subList(0, dogs.size - 1)).shuffled()
    }
}
