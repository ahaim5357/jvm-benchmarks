package dev.nulli.jvm_benchmarks.kotlin_1_6_10.benchmark

import dev.nulli.jvm_benchmarks.kotlin_1_6_10.execution.ArrayLoopExecution
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole

open class ArrayLoopBenchmarks {

    @Benchmark
    fun forLoop(ex: ArrayLoopExecution, bl: Blackhole) {
        val modifier = ex.modifier!!
        for (value in ex.values!!) {
            bl.consume(value + modifier)
        }
    }

    @Benchmark
    fun forIndexLoop(ex: ArrayLoopExecution, bl: Blackhole) {
        val values = ex.values!!
        val modifier = ex.modifier!!
        for (i in values.indices) {
            bl.consume(values[i] + modifier)
        }
    }

    @Benchmark
    fun whileLoop(ex: ArrayLoopExecution, bl: Blackhole) {
        val values = ex.values!!
        val modifier = ex.modifier!!
        var i = 0
        while (i < values.size) {
            bl.consume(values[i++] + modifier)
        }
    }

    @Benchmark
    fun doWhileLoop(ex: ArrayLoopExecution, bl: Blackhole) {
        val values = ex.values!!
        val modifier = ex.modifier!!
        var i = 0
        do {
            bl.consume(values[i++] + modifier)
        } while (i < values.size)
    }

    @Benchmark
    fun forEach(ex: ArrayLoopExecution, bl: Blackhole) {
        val modifier = ex.modifier!!
        ex.values!!.forEach { value -> bl.consume(value + modifier) }
    }
}
