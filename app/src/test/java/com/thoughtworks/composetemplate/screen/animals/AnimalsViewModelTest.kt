package com.thoughtworks.composetemplate.screen.animals

import com.thoughtworks.composetemplate.common.network.animal.model.Animal
import com.thoughtworks.composetemplate.testutils.BaseRobolectricCoroutineTest
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

@ExperimentalCoroutinesApi
class AnimalsViewModelTest : BaseRobolectricCoroutineTest() {

    @MockK
    private lateinit var animalRepository: AnimalRepository

    private lateinit var animalsViewModel: AnimalsViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        animalsViewModel = AnimalsViewModel(animalRepository)
    }

    @Test
    fun `should return the value gotten from AnimalRepository`() = runTest {
        // given
        val valueFromAnimalRepository = listOf(Animal("cat1"), Animal("dog1"))
        coEvery { animalRepository.getAnimals() } returns valueFromAnimalRepository

        // when
        val actual = animalsViewModel.fetch()

        // then
        assertThat(actual).isEqualTo(valueFromAnimalRepository)
    }
}
