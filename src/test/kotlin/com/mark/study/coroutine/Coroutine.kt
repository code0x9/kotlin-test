package com.mark.study.coroutine

import kotlin.coroutines.experimental.*

fun main(args: Array<String>) {
    val fibonacciSeq = buildSequence {
        var a = 0
        var b = 1

        yield(1)

        while (true) {
            yield(a + b)

            val tmp = a + b
            a = b
            b = tmp
        }
    }

    // Print the first five Fibonacci numbers
    println(fibonacciSeq.take(8).toList())
    println(fibonacciSeq.drop(8).take(8).toList())

    val lazySeq = buildSequence {
        print("START ")
        for (i in 1..5) {
            yield(i)
            print("STEP ")
        }
        print("END")
    }

    // Print the first three elements of the sequence
    lazySeq.take(3).forEach { print("$it ") }
    println()
    println(lazySeq.take(3).toList())

    val lazySeq2 = buildSequence {
        yield(0)
        yieldAll(1..10)
    }

    lazySeq2.forEach { print("$it ") }
}
