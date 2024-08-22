package com.thoughtworks.boilerplate.screens.animals

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.test.onNodeWithText
import coil3.compose.AsyncImage
import com.jeppeman.mockposable.mockk.everyComposable
import com.jeppeman.mockposable.mockk.verifyComposable
import com.thoughtworks.boilerplate.common.components.querying.ErrorPlaceholder
import com.thoughtworks.boilerplate.common.components.querying.ErrorType
import com.thoughtworks.boilerplate.data.model.Animal
import com.thoughtworks.boilerplate.testutils.BaseComposeTest
import com.thoughtworks.boilerplate.testutils.CompositionProvider
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockkStatic
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class AnimalsScreenTest : BaseComposeTest() {

    @MockK
    lateinit var animalRepository: AnimalRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        mockkStatic("coil3.compose.SingletonAsyncImageKt")
        everyComposable {
            AsyncImage(
                modifier = any<Modifier>(),
                model = any(),
                contentDescription = any(),
                contentScale = ContentScale.Crop,
            )
        } returns Unit
    }

    @Test
    fun `should render title in AppBar`() {
        // when
        composeTestRule.setContent {
            CompositionProvider {
                AnimalsScreen(repository = animalRepository)
            }
        }

        // then
        composeTestRule.onNodeWithText("Animals").assertExists()
    }

    @Test
    fun `should render images when repository returns animals`() = runTest {
        // given
        val animals = listOf(
            Animal("1", "url1"),
            Animal("2", "url2"),
            Animal("3", "url3"),
        )
        coEvery { animalRepository.getAnimals() } returns animals

        // when
        composeTestRule.setContent {
            CompositionProvider {
                AnimalsScreen(animalRepository)
            }
        }

        // then
        verifyComposable {
            for (url in arrayOf("url1", "url2", "url3")) {
                AsyncImage(
                    modifier = any<Modifier>(),
                    model = url,
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                )
            }
        }
    }

    @Test
    fun `should not render images when repository throws exception`() = runTest {
        // given
        coEvery { animalRepository.getAnimals() } throws Exception()
        mockkStatic("com.thoughtworks.boilerplate.common.components.querying.ErrorPlaceholderKt")
        everyComposable {
            ErrorPlaceholder(
                modifier = any(),
                errorType = any(),
                onRetry = any(),
            )
        } returns Unit

        // when
        composeTestRule.setContent {
            CompositionProvider {
                AnimalsScreen(animalRepository)
            }
        }

        // then
        verifyComposable {
            ErrorPlaceholder(
                modifier = any(),
                errorType = ErrorType.LOADING_OR_PARSING,
                onRetry = any(),
            )
        }
    }
}
