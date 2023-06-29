package com.thoughtworks.composetemplate.testutils

import org.junit.Rule

abstract class BaseCoroutineTest {
    @get:Rule
    val mainCoroutineRule = UnconfinedMainCoroutineRule()
}
