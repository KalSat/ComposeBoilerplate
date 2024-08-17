package com.thoughtworks.boilerplate.screen.home

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
        val name = "name"

        // when
        composeTestRule.setContent {
            Greeting(name = name)
        }

        // then
        composeTestRule.onNodeWithText("Hello $name!").assertExists()
    }
}
