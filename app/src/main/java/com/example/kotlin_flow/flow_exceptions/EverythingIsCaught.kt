package com.example.kotlin_flow.flow_exceptions

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun everythingIsCaught(): Flow<String> = flow {
    for (i in 1..3) {
        println("Emitting $i")
        emit(i)
    }
}
    .map { value ->
        check(value <= 1) { "Crashed on $value" }
        "string $value"
    }

fun main() = runBlocking<Unit> {
    try {
        everythingIsCaught().collect{ value ->
            println(value)
        }
    } catch (e: Throwable) {
        println("Exception $e")
    }
}