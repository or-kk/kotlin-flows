package com.example.kotlin_flow

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

fun simple(log: String): Flow<Int> = flow {
    println("[${Thread.currentThread().name}] Started $log flow")
    for (i in 1..3) {
        emit(i)
    }
}

fun main() = runBlocking {
    simple("simple").collect { value ->
        println("[${Thread.currentThread().name}] Collected $value")
    }
}