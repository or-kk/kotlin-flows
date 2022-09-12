package com.example.kotlin_flow.flow_completion

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.runBlocking

fun successfulCompletion(): Flow<Int> = (1..3).asFlow()

fun main() = runBlocking<Unit> {
    successfulCompletion()
        .onCompletion { cause -> println("Flow completed with $cause")  }
        .collect { value ->
            check(value <= 1) { "Collected $value"}
            println(value)
        }
}
