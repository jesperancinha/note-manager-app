package org.jesperancinha.manager.note.plugins

import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import org.jesperancinha.manager.note.dao.StoryDao

fun Application.configureRouting(storyDao: StoryDao) {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
    }
}
