package com.nurbk.ps.v1.image

import org.junit.Assert
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExceptionTest {


    var leetCode : LeetCode?=null
    var leetCodes : LeetCode =LeetCode()


    @Test
    fun isValid() {
        try {
            leetCode!!.isMatch("aa","a*")
            Assert.fail("Null Pinter Exception")
        } catch (e: NullPointerException) {
        }
    }
    @Test
    fun isValidIsNull() {
        try {
            val arr = intArrayOf(
                0, 1, 0, 2, 1, 0,
                1, 3, 2, 1, 2, 1
            )
            val n = arr.size
            leetCodes.maxWater2(arr,n)
            Assert.fail("Index Out Of Bounds Exception")
        } catch (e: IndexOutOfBoundsException) {
        }
    }


}