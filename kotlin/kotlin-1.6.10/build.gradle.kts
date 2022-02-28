// Add plugins
plugins {
    kotlin("jvm") version "1.6.10"
    id("org.cadixdev.licenser")
    id("me.champeau.jmh")
}

// Set project information
base.archivesName.set("${extra["base.id"]}-${extra["benchmark.kotlin.id"]}-${extra["benchmark.kotlin.1_6_10.id"]}")
version = extra["benchmark.kotlin.1_6_10.version"] as String
