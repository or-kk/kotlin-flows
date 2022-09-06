package com.example.kotlin_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun flowsAreCold(): Flow<Int> = flow {
    println("Flow started")
    for (i in 1..3) {
        delay(100)
        emit(i)
    }
}

fun main() = runBlocking<Unit> {
    println("Calling simple function...")
    val flow = flowsAreCold()
    println("Calling collect...")
    flow.collect { value -> println(value)}
    println("Calling collect again...")
    flow.collect { value -> println(value)}
}