package com.example.kotlin_flow

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.runBlocking

suspend fun transformOperator() {

    (1..3).asFlow() // a flow requests
        .transform { request ->
            emit("Making request $request")
            emit(performRequest(request))
        }
        .collect { response -> println(response) }
}

fun main() = runBlocking{
    transformOperator()
}