package dev.nulli.jvm_benchmarks.java_17.execution;

import java.util.Random;

public class ArrayLoopExecution extends AbstractLoopExecution<Integer, int[]> {

    public ArrayLoopExecution() {
        super((r, i) -> r.ints(i).toArray(), Random::nextInt);
    }
}
