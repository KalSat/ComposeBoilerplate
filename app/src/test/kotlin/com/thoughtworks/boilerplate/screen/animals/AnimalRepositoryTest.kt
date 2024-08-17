package com.thoughtworks.boilerplate.screen.animals

import com.thoughtworks.boilerplate.common.network.animal.CatApi
import com.thoughtworks.boilerplate.common.network.animal.DogApi
import com.thoughtworks.boilerplate.common.network.animal.model.Animal
import com.thoughtworks.boilerplate.testutils.BaseCoroutineTest
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class AnimalRepositoryTest : BaseCoroutineTest() {

    @MockK
    private lateinit var catApi: CatApi

    @MockK
    private lateinit var dogApi: DogApi

    private lateinit var animalRepository: AnimalRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        animalRepository = AnimalRepository(
            catApi = catApi,
            dogApi = dogApi,
            dispatcher = mainCoroutineRule.testDispatcher
        )
    }

    @Test
    fun `should return the value gotten from CatApi`() = runTest {
        // given
        val valueFromCatApi = listOf(Animal("cat1"), Animal("cat2"))
        coEvery { catApi.getCats() } returns valueFromCatApi

        // when
        val actual = animalRepository.getCats()

        // then
        assertThat(actual).isEqualTo(valueFromCatApi)
    }

    @Test
    fun `should return the value gotten from DogApi`() = runTest {
        // given
        val valueFromDogApi = listOf(Animal("dog1"), Animal("dog2"))
        coEvery { dogApi.getDogs() } returns valueFromDogApi

        // when
        val actual = animalRepository.getDogs()

        // then
        assertThat(actual).isEqualTo(valueFromDogApi)
    }

    @Test
    fun `should merge and shuffle the values gotten from CatApi and DogApi`() = runTest {
        // given
        val valueFromCatApi = MutableList(10) { i -> Animal("cat$i") }
        val valueFromDogApi = MutableList(10) { i -> Animal("dog$i") }
        coEvery { catApi.getCats() } returns valueFromCatApi
        coEvery { dogApi.getDogs() } returns valueFromDogApi

        // when
        val actual = animalRepository.getAnimals()

        // then
        assertThat(actual.size).isEqualTo(valueFromDogApi.size + valueFromCatApi.size - 2)
    }
}
