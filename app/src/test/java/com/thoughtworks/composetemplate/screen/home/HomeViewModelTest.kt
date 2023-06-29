package com.thoughtworks.composetemplate.screen.home

import com.thoughtworks.composetemplate.testutils.BaseRobolectricTest
import io.mockk.MockKAnnotations
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

class HomeViewModelTest : BaseRobolectricTest() {

    private lateinit var viewModel: HomeViewModel

    @Before
    fun setUp() {
        MockKAnnotations.init(this)

        viewModel = HomeViewModel()
    }

    @Test
    fun `should be specific string value`() {
        assertThat(viewModel.name).isEqualTo("Android")
    }
}
