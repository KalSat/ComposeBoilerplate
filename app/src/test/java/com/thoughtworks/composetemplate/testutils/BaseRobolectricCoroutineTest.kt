package com.thoughtworks.composetemplate.testutils

import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Rule

@OptIn(ExperimentalCoroutinesApi::class)
abstract class BaseRobolectricCoroutineTest : BaseRobolectricTest() {
    @get:Rule
    val mainCoroutineRule = UnconfinedMainCoroutineRule()
}
