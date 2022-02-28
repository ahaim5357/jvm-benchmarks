package dev.nulli.jvm_benchmarks.groovy_4_0_0.execution

import org.openjdk.jmh.annotations.*

import java.util.concurrent.ThreadLocalRandom

@State(Scope.Benchmark)
abstract class AbstractLoopExecution<E, L> {

    private final Closure<L> valuesFunc
    private final Closure<E> modifierFunc

    protected AbstractLoopExecution(final Closure<L> valuesFunc, final Closure<E> modifierFunc) {
        this.valuesFunc = valuesFunc
        this.modifierFunc = modifierFunc
    }

    @Param([
            "100",
            "1000", "5000",
            "1000000", "2000000", "3000000", "5000000", "7000000",
            "10000000", "20000000", "30000000", "50000000", "70000000",
            "100000000"
    ])
    protected int iterations

    public L values
    public E modifier

    @Setup(Level.Iteration)
    void setup() {
        this.values = null
        this.values = this.valuesFunc.call(ThreadLocalRandom.current(), this.iterations)
        this.modifier = this.modifierFunc.call(ThreadLocalRandom.current())
    }
}
