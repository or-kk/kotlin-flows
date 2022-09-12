package com.example.kotlin_flow.flow_completion

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.lang.RuntimeException

fun declarativeSimple(): Flow<Int> = flow {
    emit(1)
    throw RuntimeException()
}

fun main() = runBlocking<Unit> {
    declarativeSimple()
        .onCompletion { cause -> if (cause != null) println("Flow completed exceptionally") }
        .catch { cause -> println("Caught exception") }
        .collect { value -> println(value) }
}