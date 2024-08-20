package com.thoughtworks.boilerplate.testutils

import org.junit.Rule

abstract class BaseCoroutineTest {
    @get:Rule
    val mainCoroutineRule = UnconfinedMainCoroutineRule()
}
