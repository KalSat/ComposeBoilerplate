package com.thoughtworks.boilerplate.screens.home

import io.kotest.matchers.shouldBe
import io.mockk.MockKAnnotations
import org.junit.Before
import org.junit.Test

class HomeViewModelTest {

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        viewModel = HomeViewModel()
    }

    @Test
    fun `should be specific string value`() {
        viewModel.name shouldBe "Android"
    }
}
