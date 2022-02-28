package dev.nulli.jvm_benchmarks.groovy_4_0_0.execution

class ArrayLoopExecution extends AbstractLoopExecution<Integer, int[]> {

    ArrayLoopExecution() {
        super({ r, i -> r.ints(i).toArray() }, Random::nextInt)
    }
}
