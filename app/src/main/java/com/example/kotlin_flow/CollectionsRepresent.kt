package com.example.kotlin_flow

fun collectionsRepresent(): List<Int> = listOf(1, 2, 3)

fun main() {
    collectionsRepresent().forEach { value ->
        println(value)
    }
}

