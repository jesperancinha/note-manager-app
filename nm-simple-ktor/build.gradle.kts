plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
    alias(libs.plugins.kotlin.serialization)
    jacoco
}

group = "org.jesperancinha"
version = "0.0.1"
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    api("io.ktor:ktor-server-core-jvm")
    api("io.ktor:ktor-server-netty-jvm")
    api("io.ktor:ktor-server-auth-jvm")
    api("io.ktor:ktor-server-auth-jwt-jvm")
    api("io.ktor:ktor-server-partial-content-jvm")
    api("io.ktor:ktor-server-metrics-jvm")
    api("io.ktor:ktor-server-metrics-micrometer-jvm")
    api("io.ktor:ktor-server-websockets-jvm")
    api("io.ktor:ktor-server-content-negotiation-jvm")
    api("io.ktor:ktor-serialization-kotlinx-json-jvm")
    api("io.ktor:ktor-server-websockets-jvm")
    api("io.ktor:ktor-server-html-builder-jvm")
    api("io.ktor:ktor-server-resources-jvm")
    api(libs.micrometer.registry.prometheus)
    api(libs.arrow.core.jvm)
    api(libs.suspendapp.jvm)
    api(libs.arrow.fx.coroutines.jvm)
    api(libs.ktorm.core)
    api(libs.logback.classic)
    api(libs.exposed.core)
    api(libs.exposed.dao)
    api(libs.exposed.jdbc)
    testImplementation("io.ktor:ktor-server-tests-jvm")
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.kotlinx.coroutines.debug)
}

kotlin {
    jvmToolchain(25)
}