package dev.nulli.jvm_benchmarks.scala_2_13_8

import org.openjdk.jol.info.ClassLayout

object DataSize {

    def main(args: Array[String]): Unit = {
        viewClassData("Integer", classOf[Int])
        viewObjectData("Int Array 100", new Array[Int](100))
        viewObjectData("Int Array 1K", new Array[Int](1000))
        viewObjectData("Int Array 5K", new Array[Int](5000))
        viewObjectData("Int Array 50K", new Array[Int](50000))
        viewObjectData("Int Array 1M", new Array[Int](1000000))
        viewObjectData("Int Array 2M", new Array[Int](2000000))
        viewObjectData("Int Array 3M", new Array[Int](3000000))
        viewObjectData("Int Array 5M", new Array[Int](5000000))
        viewObjectData("Int Array 7M", new Array[Int](7000000))
        viewObjectData("Int Array 10M", new Array[Int](10000000))
        viewObjectData("Int Array 20M", new Array[Int](20000000))
        viewObjectData("Int Array 30M", new Array[Int](30000000))
        viewObjectData("Int Array 50M", new Array[Int](50000000))
        viewObjectData("Int Array 70M", new Array[Int](70000000))
        viewObjectData("Int Array 100M", new Array[Int](100000000))
    }

    def  viewClassData[T](name: String, t: Class[T]): Unit = {
        viewData(name, ClassLayout.parseClass(t))
    }

    def viewObjectData[T](name: String, t: T): Unit = {
        viewData(name, ClassLayout.parseInstance(t))
    }

    def viewData(name: String, layout: ClassLayout): Unit = {
        println("#########################################")
        println(s"Class Layout: $name")
        println("-----------------------------------------")
        println(layout.toPrintable())
        println("#########################################")
    }
}
