package com.thoughtworks.boilerplate.screens.home

import androidx.compose.ui.test.onNodeWithText
import com.thoughtworks.boilerplate.testutils.BaseComposeTest
import org.junit.Before
import org.junit.Test

class HomeScreenTest : BaseComposeTest() {

    @Before
    fun setUp() {
    }

    @Test
    fun `should render name correctly in Greeting`() {
        // when
        composeTestRule.setContent {
            HomeContent(HomeViewModel())
        }

        // then
        composeTestRule.onNodeWithText("Compose: Hello, Java 17.0.11! + Android").assertExists()
    }
}
