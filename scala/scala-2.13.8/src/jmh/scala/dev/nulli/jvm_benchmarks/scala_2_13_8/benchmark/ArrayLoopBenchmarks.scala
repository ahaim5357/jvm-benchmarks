package dev.nulli.jvm_benchmarks.scala_2_13_8.benchmark

import dev.nulli.jvm_benchmarks.scala_2_13_8.execution.ArrayLoopExecution
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.infra.Blackhole

class ArrayLoopBenchmarks {

    @Benchmark
    def forLoop(ex: ArrayLoopExecution, bl: Blackhole): Unit = {
        val modifier = ex.modifier.get
        for (value <- ex.values.get) {
            bl.consume(value + modifier)
        }
    }

    @Benchmark
    def whileLoop(ex: ArrayLoopExecution, bl: Blackhole): Unit = {
        val modifier = ex.modifier.get
        val values = ex.values.get
        var i = 0
        while (i < values.length) {
            bl.consume(values(i) + modifier)
            i += 1
        }
    }

    @Benchmark
    def doWhileLoop(ex: ArrayLoopExecution, bl: Blackhole): Unit = {
        val modifier = ex.modifier.get
        val values = ex.values.get
        var i = 0
        do {
            bl.consume(values(i) + modifier)
            i += 1
        } while (i < values.length)
    }

    @Benchmark
    def forEachLoop(ex: ArrayLoopExecution, bl: Blackhole): Unit = {
        val modifier = ex.modifier.get
        ex.values.get.foreach(value => bl.consume(value + modifier))
    }
}
