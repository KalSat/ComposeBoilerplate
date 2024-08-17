package com.thoughtworks.composetemplate.testutils

import org.junit.Rule

abstract class BaseRobolectricCoroutineTest : BaseRobolectricTest() {
    @get:Rule
    val mainCoroutineRule = UnconfinedMainCoroutineRule()
}
