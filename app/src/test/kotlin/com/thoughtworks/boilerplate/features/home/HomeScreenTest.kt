package com.thoughtworks.boilerplate.features.home

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
        // given
        val count = "5"

        // when
        composeTestRule.setContent {
            Greeting(count = count)
        }

        // then
        composeTestRule.onNodeWithText("Hello, you have clicked $count times!").assertExists()
    }
}
