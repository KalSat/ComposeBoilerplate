package com.thoughtworks.boilerplate.features.home

import com.thoughtworks.boilerplate.testutils.BaseComposeTest
import kotlin.reflect.KFunction0
import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class UseCounterTest : BaseComposeTest() {

    @Test
    fun `should initialize count to 0`() {
        // given
        var count = -1
        composeTestRule.setContent {
            val (cnt, _) = useCounter()
            count = cnt
        }

        // then
        assertThat(count).isEqualTo(0)
    }

    @Test
    fun `should increment count when increment function is called`() {
        // given
        var count = -1
        var increment: KFunction0<Unit>? = null
        composeTestRule.setContent {
            val (cnt, inc) = useCounter()
            count = cnt
            increment = inc
        }

        // when
        composeTestRule.runOnUiThread {
            increment?.invoke()
        }
        composeTestRule.waitForIdle()

        // then
        assertThat(count).isEqualTo(1)
    }

    @Test
    fun `should increment count multiple times sequentially`() {
        // given
        var count = -1
        var increment: KFunction0<Unit>? = null
        composeTestRule.setContent {
            val (cnt, inc) = useCounter()
            count = cnt
            increment = inc
        }

        // when
        composeTestRule.runOnUiThread {
            increment?.invoke()
            increment?.invoke()
            increment?.invoke()
        }
        composeTestRule.waitForIdle()

        // then
        assertThat(count).isEqualTo(3)
    }
}
