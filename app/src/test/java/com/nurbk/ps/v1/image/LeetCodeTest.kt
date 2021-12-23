package com.nurbk.ps.v1.image

import org.junit.*

class LeetCodeTest {
    companion object{
        var leetCode : LeetCode?=null

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
    }

    @Before
    fun beforeTest() {
        println("beforeTest")
    }


    @After
    fun afterTest() {
        println("afterTest")
    }

    @Test
    fun isMatchTest(){
        Assert.assertTrue(leetCode!!.isMatch("aa","a*"))
    }

    @Test
    fun maxWaterTest(){
        val arr = intArrayOf(
            0, 1, 0, 2, 1, 0,
            1, 3, 2, 1, 2, 1
        )
        val n = arr.size
        Assert.assertEquals(6,leetCode!!.maxWater(arr,n))
    }

    @Test
    fun findSubstringTest(){

        Assert.assertEquals(intArrayOf(0,9),leetCode!!.findSubstring(  "barfoothefoobarman", arrayOf("foo","bar")))
    }

    @Test
    fun numIdenticalPairsTest(){

        Assert.assertEquals(4,leetCode!!.numIdenticalPairs(   arrayListOf(1,2,3,1,1,3)))
    }

}