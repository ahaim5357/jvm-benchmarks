package dev.nulli.jvm_benchmarks.kotlin_1_6_10

import org.openjdk.jol.info.ClassLayout
import kotlin.reflect.KClass

fun main() {
    viewClassData("Integer", Int::class)
    viewObjectData("Int Array 100", IntArray(100))
    viewObjectData("Int Array 1K", IntArray(1000))
    viewObjectData("Int Array 5K", IntArray(5000))
    viewObjectData("Int Array 50K", IntArray(50000))
    viewObjectData("Int Array 1M", IntArray(1000000))
    viewObjectData("Int Array 2M", IntArray(2000000))
    viewObjectData("Int Array 3M", IntArray(3000000))
    viewObjectData("Int Array 5M", IntArray(5000000))
    viewObjectData("Int Array 7M", IntArray(7000000))
    viewObjectData("Int Array 10M", IntArray(10000000))
    viewObjectData("Int Array 20M", IntArray(20000000))
    viewObjectData("Int Array 30M", IntArray(30000000))
    viewObjectData("Int Array 50M", IntArray(50000000))
    viewObjectData("Int Array 70M", IntArray(70000000))
    viewObjectData("Int Array 100M", IntArray(100000000))
}

private fun <T : Any> viewClassData(name: String, t: KClass<T>) {
    viewData(name, ClassLayout.parseClass(t.java))
}

private fun <T> viewObjectData(name: String, t: T) {
    viewData(name, ClassLayout.parseInstance(t))
}

private fun viewData(name: String, layout: ClassLayout) {
    println("#########################################")
    println("Class Layout: $name")
    println("-----------------------------------------")
    println(layout.toPrintable())
    println("#########################################")
}