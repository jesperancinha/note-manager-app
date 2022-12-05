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
        val engine = server(Netty, host = hostConfig.host, port = hostConfig.port).bind()
        engine.application.app(dependencies)
    }.use { awaitCancellation() }
}

fun <Engine : ApplicationEngine, Configuration : ApplicationEngine.Configuration> server(
    factory: ApplicationEngineFactory<Engine, Configuration>,
    port: Int = 8080,
    host: String = "0.0.0.0",
    configure: Configuration.() -> Unit = {},
    gracePeriodMillis: Duration = 1.seconds,
    timeoutMillis: Duration = 5.seconds,
): Resource<ApplicationEngine> =
    Resource({
        embeddedServer(factory, host = host, port = port, configure = configure) {
        }.apply { start() }
    }, { engine, _ ->
        engine.environment.log.info("Shutting down Ktor server...")
        engine.stop(gracePeriodMillis.inWholeMilliseconds, timeoutMillis.inWholeMilliseconds)
        engine.environment.log.info("Ktor server shutdown!")
    })

data class Dependencies(
    val storyService: StoryDao?,
    val wordDao: WordDao?
)

fun dependencies(): Resource<Dependencies> = resource {
    Dependencies(null, null)
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
