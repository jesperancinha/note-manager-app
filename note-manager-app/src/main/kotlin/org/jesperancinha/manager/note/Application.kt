package org.jesperancinha.manager.note

import arrow.continuations.SuspendApp
import arrow.fx.coroutines.Resource
import arrow.fx.coroutines.continuations.resource
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import kotlinx.coroutines.awaitCancellation
import org.jesperancinha.manager.note.config.HostConfiguration
import org.jesperancinha.manager.note.dao.StoryDao
import org.jesperancinha.manager.note.dao.WordDao
import org.jesperancinha.manager.note.plugins.*
import kotlin.time.Duration
import kotlin.time.Duration.Companion.seconds

fun main() = SuspendApp {
    val hostConfig = HostConfiguration()
    resource {
        val dependencies = dependencies().bind()
        val engine = server(host = hostConfig.host, port = hostConfig.port).bind()
        engine.application.app(dependencies)
    }.use { awaitCancellation() }
}

fun server(
    port: Int = 8080,
    host: String = "0.0.0.0",
    configure: Application.() -> Unit = {},
    gracePeriod: Duration = 1.seconds,
    timeout: Duration = 5.seconds,
): Resource<EmbeddedServer<NettyApplicationEngine, NettyApplicationEngine.Configuration>> = Resource(
    {
        embeddedServer(Netty, port = port, host = host, module = configure).apply { start(wait = false) }
    },
    { server, _ ->
        server.engine.environment.log.info("Shutting down Ktor server...")
        server.stop(gracePeriod.inWholeMilliseconds, timeout.inWholeMilliseconds)
        server.engine.environment.log.info("Ktor server shutdown!")
    }
)

data class Dependencies(
    val storyService: StoryDao?,
    val wordDao: WordDao?
)

fun dependencies(): Resource<Dependencies> = resource {
    Dependencies(null, null)
}

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    configureRouting()
}

fun Application.app(module: Dependencies) {
//    configureSecurity()
    configureHTTP()
    configureMonitoring()
    configureSerialization()
    configureSockets()
    configureAdministration()
    configureRouting(module.storyService)
}
