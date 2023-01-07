package org.jesperancinha.plugins

import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*


val allArticles = listOf(
    "Lars: If you write that in the book I will throw the book away.",
    "Merchant: I would never call him Mr. Comp you know. You don't even know what the whole word is or what it means. Imagine that it's something intimate like a past someone special to him ?"
)

val allMessages = listOf(
    "Priest: I understand where you are coming from, but as much as you may want to label this as a harmless joke, it is not. Words have power especially nicknames. What is positive for many may not be felt the same way for the receiver of this nonsense. So please don't do this anymore."
)

@Resource("/news")
class NewsReport

@Resource("/messages")
class Messages

fun Application.configureRouting() {
    routing {
        get("/") {
            call.respondText("Hello World!")
        }
        get<NewsReport> {
            call.respondText(allArticles.random())
        }

        get<Messages> {
            call.respondText(allMessages.random())
        }
    }
}
