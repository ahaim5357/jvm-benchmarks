import java.util.Calendar
import org.cadixdev.gradle.licenser.Licenser
import me.champeau.jmh.JMHPlugin
import java.time.Instant
import java.time.format.DateTimeFormatter
import java.time.ZoneId

// Add plugins
plugins {
    java
    id("org.cadixdev.licenser")
    id("me.champeau.jmh")
}

// Cache some properties
internal val artifactGroup: String = extra["base.group"] as String
internal val fileEncoding: String = extra["file.encoding"] as String
internal val jvmVersion: String = extra["jvm.version"] as String
internal val jmhArtifactVersion: String = extra["jmh.version"] as String
internal val jolVersion: String = extra["jol.version"] as String
internal val headerFile: TextResource = resources.text.fromFile(rootProject.file("HEADER"))
internal val startYear: String = extra["base.year.start"] as String
internal val currentYear: Int = Calendar.getInstance().get(Calendar.YEAR)
internal val author: String = extra["base.author"] as String
internal val projectName: String = extra["base.name"] as String

subprojects {
    // Java Settings
    plugins.withType<JavaPlugin> {
        group = artifactGroup
        java {
            toolchain.languageVersion.set(JavaLanguageVersion.of(jvmVersion))

            withSourcesJar()
            withJavadocJar()
        }
        tasks.withType<JavaCompile>().configureEach {
            options.encoding = fileEncoding
        }
        tasks.javadoc {
            options {
                encoding = fileEncoding
                if (this is StandardJavadocDocletOptions)
                    tags(
                        "apiNote:a:API Note:",
                        "implSpec:a:Implementation Requirements:",
                        "implNote:a:Implementation Note:"
                    )
            }
        }

        // Manifest Attributes
        afterEvaluate {
            tasks.jar {
                manifest.attributes(mapOf(
                    "Specification-Title" to projectName,
                    "Specification-Vendor" to author,
                    "Specification-Version" to (project.version as String).split('-')[0],
                    "Implementation-Title" to base.archivesName.get(),
                    "Implementation-Vendor" to author,
                    "Implementation-Version" to project.version,
                    "Implementation-Timestamp" to DateTimeFormatter.ISO_INSTANT.format(Instant.now())
                ))
            }
        }

        // Benchmarking
        plugins.withType<JMHPlugin> {
            repositories {
                mavenCentral()
            }
            dependencies {
                jmh(
                    group = "org.openjdk.jmh",
                    name = "jmh-core",
                    version = jmhArtifactVersion
                )
                implementation(
                    group = "org.openjdk.jol",
                    name = "jol-core",
                    version = jolVersion
                )
                jmh(
                    group = "org.openjdk.jmh",
                    name = "jmh-generator-annprocess",
                    version = jmhArtifactVersion
                )
            }

            afterEvaluate {
                jmh {
                    fork.set(1)
                    warmupForks.set(1)
                    warmupIterations.set(1)
                    iterations.set(20)
                    timeUnit.set("ms")
                    benchmarkMode.set(listOf("thrpt", "avgt"))
                    threads.set(3)

                    resultsFile.set(file("${buildDir}/reports/jmh/${
                        base.archivesName.get()
                    }/${
                        DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss").withZone(ZoneId.systemDefault()).format(Instant.now())
                    }-results.csv"))
                    resultFormat.set("CSV")

                    jmhVersion.set(jmhArtifactVersion)
                }
            }
        }
    }

    // License Settings
    plugins.withType<Licenser> {
        license {
            header.set(headerFile)
            properties {
                set("startYear", startYear)
                set("currentYear", currentYear)
                set("author", author)
            }
            include("**/*.java")
        }
    }
}

// For JMH
repositories {
    mavenCentral()
}
jmh {
    jmhVersion.set(jmhArtifactVersion)
}
