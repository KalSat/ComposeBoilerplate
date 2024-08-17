package com.thoughtworks.boilerplate.screen.animals

import com.thoughtworks.boilerplate.common.di.IoDispatcher
import com.thoughtworks.boilerplate.common.network.animal.CatApi
import com.thoughtworks.boilerplate.common.network.animal.DogApi
import javax.inject.Inject
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class AnimalRepository @Inject constructor(
    private val catApi: CatApi,
    private val dogApi: DogApi,
    @IoDispatcher private val dispatcher: CoroutineDispatcher
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
