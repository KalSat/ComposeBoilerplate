package com.thoughtworks.boilerplate.screens.animals

import com.thoughtworks.boilerplate.data.model.Animal
import com.thoughtworks.boilerplate.data.network.animalApi.getCats
import com.thoughtworks.boilerplate.data.network.animalApi.getDogs
import com.thoughtworks.boilerplate.testutils.BaseCoroutineTest
import io.kotest.matchers.shouldBe
import io.mockk.coEvery
import io.mockk.mockkStatic
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class AnimalRepositoryTest : BaseCoroutineTest() {

    private lateinit var animalRepository: AnimalRepository

    @Before
    fun setUp() {
        mockkStatic(::getCats)
        mockkStatic(::getDogs)
        animalRepository = AnimalRepository(
            dispatcher = mainCoroutineRule.testDispatcher
        )
    }

    @Test
    fun `should return the value gotten from CatApi`() = runTest {
        // given
        val valueFromCatApi = listOf(Animal("cat1"), Animal("cat2"))
        coEvery { getCats() } returns valueFromCatApi

        // when
        val actual = animalRepository.fetchCats()

        // then
        actual shouldBe valueFromCatApi
    }

    @Test
    fun `should return the value gotten from DogApi`() = runTest {
        // given
        val valueFromDogApi = listOf(Animal("dog1"), Animal("dog2"))
        coEvery { getDogs() } returns valueFromDogApi

        // when
        val actual = animalRepository.fetchDogs()

        // then
        actual shouldBe valueFromDogApi
    }

    @Test
    fun `should merge and shuffle the values gotten from CatApi and DogApi`() = runTest {
        // given
        val valueFromCatApi = MutableList(10) { i -> Animal("cat$i") }
        val valueFromDogApi = MutableList(10) { i -> Animal("dog$i") }
        coEvery { getCats() } returns valueFromCatApi
        coEvery { getDogs() } returns valueFromDogApi

        // when
        val actual = animalRepository.getAnimals()

        // then
        actual.size shouldBe valueFromDogApi.size + valueFromCatApi.size - 2
    }
}
