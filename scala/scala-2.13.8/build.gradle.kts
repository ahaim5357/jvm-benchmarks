// Add plugins
plugins {
    scala
    id("org.cadixdev.licenser")
    id("me.champeau.jmh")
}

// Set project information
base.archivesName.set("${extra["base.id"]}-${extra["benchmark.scala.id"]}-${extra["benchmark.scala.2_13_8.id"]}")
version = extra["benchmark.scala.2_13_8.version"] as String

dependencies {
    implementation(
        group = "org.scala-lang",
        name = "scala-library",
        version = "2.13.8"
    )
}
