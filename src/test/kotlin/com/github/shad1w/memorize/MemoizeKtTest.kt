package com.github.shad1w.memorize

import org.testng.Assert.*
import org.testng.annotations.Test

class MemoizeKtTest {
	private var memoizationCallCount = 0

	@Test
	fun `memoized value should only be computed once`() {
		assertEquals(memoizedFunction(), "MyValue")
		assertEquals(memoizedFunction(), "MyValue")

		assertEquals(memoizationCallCount, 1)
	}

	private fun memoizedFunction() = memoize {
		memoizationCallCount++
		"MyValue"
	}
}