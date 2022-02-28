// Add plugins
plugins {
    java
    id("org.cadixdev.licenser")
    id("me.champeau.jmh")
}

// Set project information
base.archivesName.set("${extra["base.id"]}-${extra["benchmark.java.id"]}-${extra["benchmark.java.17.id"]}")
version = extra["benchmark.java.17.version"] as String
