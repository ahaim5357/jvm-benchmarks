package dev.nulli.jvm_benchmarks.java_17.execution;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.Function;

@State(Scope.Benchmark)
public abstract class AbstractLoopExecution<E, L> {

    private final BiFunction<Random, Integer, L> valuesFunc;
    private final Function<Random, E> modifierFunc;

    protected AbstractLoopExecution(final BiFunction<Random, Integer, L> valuesFunc, final Function<Random, E> modifierFunc) {
        this.valuesFunc = valuesFunc;
        this.modifierFunc = modifierFunc;
    }

    @Param({
            "100",
            "1000", "5000",
            "1000000", "2000000", "3000000", "5000000", "7000000",
            "10000000", "20000000", "30000000", "50000000", "70000000",
            "100000000"
    })
    protected int iterations;

    public L values;
    public E modifier;

    @Setup(Level.Iteration)
    public void setup() {
        this.values = null;
        this.values = this.valuesFunc.apply(ThreadLocalRandom.current(), this.iterations);
        this.modifier = this.modifierFunc.apply(ThreadLocalRandom.current());
    }
}
