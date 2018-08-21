package com.github.shad1w.memorize

val `$memoizationCache` = mutableMapOf<Any, Any>()

inline fun <reified T : Any> Any.memoize(noinline factory: () -> T): T {
	val callerID = "${System.identityHashCode(this)}${factory.javaClass.name}"

	return `$memoizationCache`.computeIfAbsent(callerID) {factory()} as T
}