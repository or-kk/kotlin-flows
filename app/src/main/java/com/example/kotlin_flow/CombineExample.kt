package com.example.kotlin_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun main() = runBlocking<Unit> {
    val nums = (1..3).asFlow().onEach { delay(300) }
    val strs = flowOf("one", "two", "three").onEach { delay(400) }
    val startTime = System.currentTimeMillis()
    nums.combine(strs) { a, b -> "$a -> $b" } // compose a single string with "combine"
        .collect { value -> //collect and print
            println("$value at ${System.currentTimeMillis() - startTime} ms from start")
        }
}