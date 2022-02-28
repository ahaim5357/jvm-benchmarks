package dev.nulli.jvm_benchmarks.kotlin_1_6_10.execution

import org.openjdk.jmh.annotations.*
import kotlin.random.Random

@State(Scope.Benchmark)
abstract class AbstractLoopExecution<E, L>(private val valuesFunc: (Random, Int) -> L, private val modifierFunc: (Random) -> E) {

    @Param(
        "100",
        "1000", "5000",
        "1000000", "2000000", "3000000", "5000000", "7000000",
        "10000000", "20000000", "30000000", "50000000", "70000000",
        "100000000"
    )
    protected var iterations: Int = 0

    var values: L? = null
    var modifier: E? = null

    @Setup(Level.Iteration)
    fun setup() {
        this.values = null
        this.values = this.valuesFunc.invoke(Random, this.iterations)
        this.modifier = this.modifierFunc.invoke(Random)
    }
}
