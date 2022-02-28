package dev.nulli.jvm_benchmarks.scala_2_13_8.execution

import org.openjdk.jmh.annotations.{Level, Param, Scope, Setup, State}

import scala.util.Random

@State(Scope.Benchmark)
abstract class AbstractLoopExecution[E, L](private val valuesFunc: (Random, Int) => L, private val modifierFunc: Random => E) {

    @Param(Array(
        "100",
        "1000", "5000",
        "1000000", "2000000", "3000000", "5000000", "7000000",
        "10000000", "20000000", "30000000", "50000000", "70000000",
        "100000000"
    ))
    protected var iterations: Int = 0

    var values: Option[L] = None
    var modifier: Option[E] = None

    @Setup(Level.Iteration)
    def setup(): Unit = {
        this.values = None
        this.values = Some(this.valuesFunc.apply(Random, this.iterations))
        this.modifier = Some(this.modifierFunc.apply(Random))
    }
}
