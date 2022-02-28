package dev.nulli.jvm_benchmarks.scala_2_13_8.execution

class ArrayLoopExecution extends AbstractLoopExecution[Int, Array[Int]]((r, i) => (1 to i).map(_ => r.nextInt()).toArray, _.nextInt())
