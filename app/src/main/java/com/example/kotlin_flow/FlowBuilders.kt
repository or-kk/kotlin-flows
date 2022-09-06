package com.example.kotlin_flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking

// Convert an integer range to a flow
fun main() = runBlocking<Unit> {
    (1..3).asFlow().collect { value -> println(value) }
}
