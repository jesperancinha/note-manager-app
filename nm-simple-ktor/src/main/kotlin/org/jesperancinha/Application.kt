package org.jesperancinha

import io.ktor.server.application.*
import io.ktor.server.resources.*
import org.jesperancinha.plugins.configureRouting

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    install(Resources)
    configureRouting()
}
