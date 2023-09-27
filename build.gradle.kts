import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.jlleitschuh.gradle.ktlint") version "11.5.1"
  kotlin("jvm") version "1.9.0"
  kotlin("kapt") version "1.9.0"
}

dependencies {
  implementation("org.jetbrains.kotlinx:kotlinx-collections-immutable:0.3.5")

  testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")
}

kotlin {
  jvmToolchain(11)
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions.suppressWarnings = true
}

val test by tasks.getting(Test::class) {
  useJUnitPlatform { }
}

ktlint {
  verbose.set(true)
  ignoreFailures.set(false)
  disabledRules.set(
    setOf(
      "comment-spacing",
      "filename",
      "import-ordering",
      "no-line-break-before-assignment",
      "no-wildcard-import",
      "multiline-if-else"
    )
  )
}

repositories {
  mavenCentral()
  maven("https://dl.bintray.com/kotlin/kotlinx")
}

kapt {
  useBuildCache = false
}
