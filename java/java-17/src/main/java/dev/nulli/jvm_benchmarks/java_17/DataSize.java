package dev.nulli.jvm_benchmarks.java_17;

import org.openjdk.jol.info.ClassLayout;

public class DataSize {

    public static void main(final String[] args) {
        viewClassData("Integer", Integer.class);
        viewObjectData("Int Array 100", new int[100]);
        viewObjectData("Int Array 1K", new int[1000]);
        viewObjectData("Int Array 5K", new int[5000]);
        viewObjectData("Int Array 50K", new int[50000]);
        viewObjectData("Int Array 1M", new int[1000000]);
        viewObjectData("Int Array 2M", new int[2000000]);
        viewObjectData("Int Array 3M", new int[3000000]);
        viewObjectData("Int Array 5M", new int[5000000]);
        viewObjectData("Int Array 7M", new int[7000000]);
        viewObjectData("Int Array 10M", new int[10000000]);
        viewObjectData("Int Array 20M", new int[20000000]);
        viewObjectData("Int Array 30M", new int[30000000]);
        viewObjectData("Int Array 50M", new int[50000000]);
        viewObjectData("Int Array 70M", new int[70000000]);
        viewObjectData("Int Array 100M", new int[100000000]);
    }

    private static <T> void viewClassData(final String name, final Class<T> t) {
        viewData(name, ClassLayout.parseClass(t));
    }

    private static <T> void viewObjectData(final String name, final T t) {
        viewData(name, ClassLayout.parseInstance(t));
    }

    private static void viewData(final String name, final ClassLayout layout) {
        System.out.println("#########################################");
        System.out.println("Class Layout: " + name);
        System.out.println("-----------------------------------------");
        System.out.println(layout.toPrintable());
        System.out.println("#########################################");
    }
}
