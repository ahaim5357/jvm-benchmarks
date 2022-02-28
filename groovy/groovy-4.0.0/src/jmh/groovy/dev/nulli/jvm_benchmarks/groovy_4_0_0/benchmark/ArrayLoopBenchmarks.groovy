package dev.nulli.jvm_benchmarks.groovy_4_0_0.benchmark

import dev.nulli.jvm_benchmarks.groovy_4_0_0.execution.ArrayLoopExecution
import org.openjdk.jmh.annotations.Benchmark
import org.openjdk.jmh.annotations.Scope
import org.openjdk.jmh.annotations.State
import org.openjdk.jmh.infra.Blackhole

@State(Scope.Benchmark)
class ArrayLoopBenchmarks {

    @Benchmark
    def forLoop(final ArrayLoopExecution ex, final Blackhole bl) {
        final int[] values = ex.values
        final int modifier = ex.modifier
        for (int i = 0; i < values.length; ++i) {
            bl.consume(values[i] + modifier)
        }
    }

    @Benchmark
    def forInLoop(final ArrayLoopExecution ex, final Blackhole bl) {
        final int modifier = ex.modifier;
        for (value in ex.values) {
            bl.consume(value + modifier);
        }
    }

    @Benchmark
    def whileLoop(final ArrayLoopExecution ex, final Blackhole bl) {
        final int[] values = ex.values
        final int modifier = ex.modifier
        int i = 0;
        while (i < values.length) {
            bl.consume(values[i++] + modifier)
        }
    }

    @Benchmark
    def doWhileLoop(final ArrayLoopExecution ex, final Blackhole bl) {
        final int[] values = ex.values
        final int modifier = ex.modifier
        int i = 0;
        do {
            bl.consume(values[i++] + modifier)
        } while (i < values.length)
    }
}
