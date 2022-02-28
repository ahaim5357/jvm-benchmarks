package dev.nulli.jvm_benchmarks.kotlin_1_6_10.execution

import kotlin.random.Random

open class ArrayLoopExecution: AbstractLoopExecution<Int, IntArray>({ r, i -> (1..i).map { r.nextInt() }.toIntArray()}, Random::nextInt)
