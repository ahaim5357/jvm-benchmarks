// Set the name of the root project
rootProject.name = extra["base.id"] as String

// Set plugin versions
pluginManagement {
    plugins {
        id("org.cadixdev.licenser") version (extra["licenser.version"] as String)
        id("me.champeau.jmh") version (extra["jmh.plugin.version"] as String)
    }

    repositories {
        gradlePluginPortal()
    }
}

internal val projectNames: Map<String, List<String>> = mapOf(
    (extra["benchmark.java.id"] as String) to listOf(
        extra["benchmark.java.17.id"] as String
    ),
    (extra["benchmark.kotlin.id"] as String) to listOf(
        extra["benchmark.kotlin.1_6_10.id"] as String
    ),
    (extra["benchmark.scala.id"] as String) to listOf(
        extra["benchmark.scala.2_13_8.id"] as String
    ),
    (extra["benchmark.groovy.id"] as String) to listOf(
        extra["benchmark.groovy.4_0_0.id"] as String
    )
)

// Add Project Builds
projectNames.forEach { (key, values) ->
    values.forEach {
        include("${key}:${key}-${it}")
    }
}
