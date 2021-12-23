package com.nurbk.ps.v1.image

import java.lang.StringBuilder

class LeetCode {

    fun isMatch(s: String, p: String): Boolean {
        val rows = s.length
        val columns = p.length
        /// Base conditions
        if (rows == 0 && columns == 0) {
            return true
        }
        if (columns == 0) {
            return false
        }
        // DP array
        val dp = Array(rows + 1) {
            BooleanArray(
                columns + 1
            )
        }
        // Empty string and empty pattern are a match
        dp[0][0] = true
        // Deals with patterns with *
        for (i in 2 until columns + 1) {
            if (p[i - 1] == '*') {
                dp[0][i] = dp[0][i - 2]
            }
        }
        // For remaining characters
        for (i in 1 until rows + 1) {
            for (j in 1 until columns + 1) {
                if (s[i - 1] == p[j - 1] || p[j - 1] == '.') {
                    dp[i][j] = dp[i - 1][j - 1]
                } else if (j > 1 && p[j - 1] == '*') {
                    dp[i][j] = dp[i][j - 2]
                    if (p[j - 2] == '.' || p[j - 2] == s[i - 1]) {
                        dp[i][j] = dp[i][j] or dp[i - 1][j]
                    }
                }
            }
        }
        return dp[rows][columns]
    }


    fun maxWater(arr: IntArray, n: Int): Int {

        // To store the maximum water
        // that can be stored
        var res = 0

        // For every element of the array
        // except first and last element
        for (i in 1 until n - 1) {

            // Find maximum element on its left
            var left = arr[i]
            for (j in 0 until i) {
                left = Math.max(left, arr[j])
            }

            // Find maximum element on its right
            var right = arr[i]
            for (j in i + 1 until n) {
                right = Math.max(right, arr[j])
            }

            // Update maximum water value
            res += Math.min(left, right) - arr[i]
        }
        return res
    }

    fun maxWater2(arr: IntArray, n: Int): Int {

        // To store the maximum water
        // that can be stored
        var res = 0

        // For every element of the array
        // except first and last element
        for (i in 1 until n - 1) {

            // Find maximum element on its left
            var left = arr[i+8]
            for (j in 0 until i) {
                left = Math.max(left, arr[j])
            }

            // Find maximum element on its right
            var right = arr[i]
            for (j in i + 1 until n) {
                right = Math.max(right, arr[j])
            }

            // Update maximum water value
            res += Math.min(left, right) - arr[i]
        }
        return res
    }

    fun findSubstring(s: String?, words: Array<String>?): ArrayList<Int> {
        val result = arrayListOf<Int>()
        if (s == null || s.isEmpty() || words == null || words.isEmpty()) {
            return result
        }

        //frequency of words
        val map = HashMap<String, Int?>()
        for (w in words) {
            if (map.containsKey(w)) {
                map[w] = map[w]!! + 1
            } else {
                map[w] = 1
            }
        }
        val len = words[0].length
        for (j in 0 until len) {
            val currentMap = HashMap<String, Int?>()
            var start = j //start index of start
            var count = 0 //count totoal qualified words so far
            var i = j
            while (i <= s.length - len) {
                val sub = s.substring(i, i + len)
                if (map.containsKey(sub)) {
                    //set frequency in current map
                    if (currentMap.containsKey(sub)) {
                        currentMap[sub] = currentMap[sub]!! + 1
                    } else {
                        currentMap[sub] = 1
                    }
                    count++
                    while (currentMap[sub]!! > map[sub]!!) {
                        val left = s.substring(start, start + len)
                        currentMap[left] = currentMap[left]!! - 1
                        count--
                        start += len
                    }
                    if (count == words.size) {
                        result.add(start) //add to result

                        //shift right and reset currentMap, count & start point
                        val left = s.substring(start, start + len)
                        currentMap[left] = currentMap[left]!! - 1
                        count--
                        start += len
                    }
                } else {
                    currentMap.clear()
                    start = i + len
                    count = 0
                }
                i += len
            }
        }
        return result
    }

    fun defangIPaddr(address: String): String{
        val sb = StringBuilder()
        for (i in 0 until address.length) {
            if (address[i] == '.') {
                sb.append("[.]")
            } else {
                sb.append(address[i])
            }
        }
        return sb.toString()
    }

    fun numIdenticalPairs(nums: ArrayList<Int>): Int {
        var res = 0
        for (i in nums.indices) for (j in i + 1 until nums.size) if (nums[i] == nums[j]) res++
        return res
    }
}