package dev.nulli.jvm_benchmarks.java_17.benchmark;

import dev.nulli.jvm_benchmarks.java_17.execution.ArrayLoopExecution;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;

public class ArrayLoopBenchmarks {

    @Benchmark
    public void forLoop(final ArrayLoopExecution ex, final Blackhole bl) {
        final int[] values = ex.values;
        final int modifier = ex.modifier;
        for (int i = 0; i < values.length; ++i) {
            bl.consume(values[i] + modifier);
        }
    }

    @Benchmark
    public void enhancedForLoop(final ArrayLoopExecution ex, final Blackhole bl) {
        final int modifier = ex.modifier;
        for (int value : ex.values) {
            bl.consume(value + modifier);
        }
    }

    @Benchmark
    public void whileLoop(final ArrayLoopExecution ex, final Blackhole bl) {
        final int[] values = ex.values;
        final int modifier = ex.modifier;
        int i = 0;
        while (i < values.length) {
            bl.consume(values[i++] + modifier);
        }
    }

    @Benchmark
    public void doWhileLoop(final ArrayLoopExecution ex, final Blackhole bl) {
        final int[] values = ex.values;
        final int modifier = ex.modifier;
        int i = 0;
        do {
            bl.consume(values[i++] + modifier);
        } while (i < values.length);
    }

    @Benchmark
    public void stream(final ArrayLoopExecution ex, final Blackhole bl) {
        final int modifier = ex.modifier;
        Arrays.stream(ex.values).forEach(i -> bl.consume(i + modifier));
    }
}
