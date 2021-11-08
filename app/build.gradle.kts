plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm") version "1.5.31"
    id("me.champeau.jmh") version "0.6.6"
}

repositories {
    mavenCentral()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin test library.
    testImplementation("org.jetbrains.kotlin:kotlin-test")

    // Use the Kotlin JUnit integration.
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit")

    jmh("org.openjdk.jmh:jmh-core:1.19")
    jmh("org.openjdk.jmh:jmh-generator-annprocess:1.19")

}

configurations {
    val jmhImplementation by getting {
        extendsFrom(configurations["implementation"])
    }
}

// Supported since 1.5.30
kotlin {
  jvmToolchain {
    (this as JavaToolchainSpec).languageVersion.set(JavaLanguageVersion.of("11"))
  }
}
