plugins {
    alias(libs.plugins.kotlin.jvm)
    alias(libs.plugins.ktor)
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
    api(libs.ktor.server.core.jvm)
    api(libs.ktor.server.netty.jvm)
    api(libs.ktor.server.auth.jvm)
    api(libs.ktor.server.auth.jwt.jvm)
    api(libs.ktor.server.partial.content.jvm)
    api(libs.ktor.server.metrics.jvm)
    api(libs.ktor.server.metrics.micrometer.jvm)
    api(libs.ktor.server.websockets.jvm)
    api(libs.ktor.server.content.negotiation.jvm)
    api(libs.ktor.serialization.kotlinx.json.jvm)
    api(libs.ktor.server.websockets.jvm)
    api(libs.micrometer.registry.prometheus)
    api(libs.arrow.core.jvm)
    api(libs.suspendapp.jvm)
    api(libs.arrow.fx.coroutines.jvm)
    api(libs.ktorm.core)
    api(libs.logback.classic)
    api(libs.exposed.core)
    api(libs.exposed.dao)
    api(libs.exposed.jdbc)
    testImplementation(libs.ktor.server.tests.jvm)
    testImplementation(libs.kotlin.test.junit)
    testImplementation(libs.kotlinx.coroutines.debug)
}

kotlin {
    jvmToolchain(21)
}