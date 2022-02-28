// Add plugins
plugins {
    groovy
    id("org.cadixdev.licenser")
    id("me.champeau.jmh")
}

// Set project information
base.archivesName.set("${extra["base.id"]}-${extra["benchmark.groovy.id"]}-${extra["benchmark.groovy.4_0_0.id"]}")
version = extra["benchmark.groovy.4_0_0.version"] as String

dependencies {
    implementation(
        group = "org.apache.groovy",
        name = "groovy",
        version = "4.0.0"
    )
}
