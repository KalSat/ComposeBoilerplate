package com.thoughtworks.boilerplate.testutils

import org.junit.Rule

abstract class BaseRobolectricCoroutineTest : BaseRobolectricTest() {
    @get:Rule
    val mainCoroutineRule = UnconfinedMainCoroutineRule()
}
