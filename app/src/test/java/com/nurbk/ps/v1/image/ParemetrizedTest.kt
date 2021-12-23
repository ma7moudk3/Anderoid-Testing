package com.nurbk.ps.v1.image

import androidx.test.filters.SmallTest
import org.junit.AfterClass
import org.junit.Assert
import org.junit.BeforeClass
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class ParameterizedTest(
    var d: String,
    var s: String
) {
    @SmallTest
    @Test
    fun isMatchTest() {
        Assert.assertTrue(leetCode!!.isMatch(d, s))
    }

    companion object {
        var leetCode: LeetCode? = null

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            println("beforeClass")
            leetCode = LeetCode()
        }


        @AfterClass
        @JvmStatic
        fun afterClass() {
            println("afterClass")
            leetCode = null
        }

        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf("aa", "a*"),
            arrayOf("pp", "p*"),
            arrayOf("ss", "s*"),
            arrayOf("dd", "d*"),
            arrayOf("ff", "f*"),
            arrayOf("rr", "r*"),
            arrayOf("yy", "y*"),
            arrayOf("uu", "u*"),
            arrayOf("pp", "p*")
        )
    }
}

@RunWith(Parameterized::class)
class ParameterizedTest2(
    var d: IntArray,
    var s: Int
) {
    @Test
    fun maxWaterTest() {
        Assert.assertEquals(6, leetCode!!.maxWater(d,s))
    }

    companion object {
        var leetCode: LeetCode? = null

        @BeforeClass
        @JvmStatic
        fun beforeClass() {
            println("beforeClass")
            leetCode = LeetCode()
        }


        @AfterClass
        @JvmStatic
        fun afterClass() {
            println("afterClass")
            leetCode = null
        }

        @JvmStatic
        @Parameterized.Parameters
        fun data() = listOf(
            arrayOf(
                intArrayOf(
                    0, 1, 0, 2, 1, 0,
                    1, 3, 2, 1, 2, 1
                ), 12
            ),
            arrayOf(
                intArrayOf(
                    0, 1, 0, 2, 1, 0,
                    1, 3, 2, 1, 2, 1
                ), 12
            ),
            arrayOf(
                intArrayOf(
                    0, 1, 0, 2, 1, 0,
                    1, 3, 2, 1, 2, 1
                ), 12
            ),
            arrayOf(
                intArrayOf(
                    0, 1, 0, 2, 1, 0,
                    1, 3, 2, 1, 2, 1
                ), 12
            ),
            arrayOf(
                intArrayOf(
                    0, 1, 0, 2, 1, 0,
                    1, 3, 2, 1, 2, 1
                ), 12
            ),
            arrayOf(
                intArrayOf(
                    0, 1, 0, 2, 1, 0,
                    1, 3, 2, 1, 2, 1
                ), 12
            )
        )
    }
}

