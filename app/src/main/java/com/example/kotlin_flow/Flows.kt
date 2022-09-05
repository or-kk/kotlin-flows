package com.example.kotlin_flow

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun simple(): Flow<Int> = flow { // flow builder
    for (i in 1..3) {
        delay(100) // pretend we are doing something useful here
        emit(i) // emit next value
    }
}

fun main() = runBlocking<Unit> {

    launch {
        for (k in 1..3) {
            println(" $k")
            delay(100)
        }
    }

    simple().collect { it ->
        println(it)
    }

    (1..3).asFlow().collect() {
        delay(100)
        println("$it")
    }
}