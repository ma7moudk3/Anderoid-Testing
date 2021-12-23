package com.nurbk.ps.v1.image

import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import java.io.IOException

class Mock {


    @Mock
    var leetCode: LeetCode = LeetCode()


    @Before
    @Throws(IOException::class)
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        println("beforeTest")
    }


    @After
    fun afterTest() {
        println("afterTest")
    }

    @Test
    fun isMatchTest() {

        val d = leetCode.isMatch("aa", "a*")
        Mockito.`when`(d).thenReturn(false)


        Assert.assertTrue(!d)
    }



    @Test
    fun maxWaterTest() {
        val arr = intArrayOf(
            0, 1, 0, 2, 1, 0,
            1, 3, 2, 1, 2, 1
        )
        val n = arr.size
        val s =  leetCode.maxWater(arr, n)
        Mockito.`when`(s).thenReturn(0)

        Assert.assertEquals(0,s)
    }
}

