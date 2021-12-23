package com.nurbk.ps.v1.image

import androidx.test.filters.LargeTest
import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@LargeTest
@Suite.SuiteClasses(
//    LeetCodeTest::class,
    ParameterizedTest::class,
    ParameterizedTest2::class,
    Mock::class,
    ExceptionTest::class
)
class TestSuite