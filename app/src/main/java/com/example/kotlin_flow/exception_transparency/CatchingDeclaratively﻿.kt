package com.example.kotlin_flow.exception_transparency

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking

fun catching(): Flow<Int> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    catching()
        .onEach { value ->
            check(value <= 1) { "Collected $value"}
            println(value)
        }
        .catch { e -> println("Catch $e") }
        .collect()
}