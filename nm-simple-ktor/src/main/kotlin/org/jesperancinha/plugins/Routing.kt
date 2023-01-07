package org.jesperancinha.plugins

import io.ktor.http.*
import io.ktor.resources.*
import io.ktor.server.application.*
import io.ktor.server.html.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.html.a
import kotlinx.html.body
import kotlinx.html.i
import kotlinx.html.p
import kotlinx.serialization.Serializable
import java.time.LocalDateTime


val allArticles = listOf(
    "Lars: If you write that in the book I will throw the book away.",
    "Merchant: I would never call him Mr. Comp you know. You don't even know what the whole word is or what it means. Imagine that it's something intimate like a past someone special to him ?"
)

val allMessages = listOf(
    "Priest: I understand where you are coming from, but as much as you may want to label this as a harmless joke, it is not. Words have power especially nicknames. What is positive for many may not be felt the same way for the receiver of this nonsense. So please don't do this anymore.",
    "Mrs Rose: I know Mr. Pereira from a long time ago my dear. He can probably help you. I know his stories and it all adds up. He can definitely help you"
)

@Resource("/main")
class MainWebPage

@Resource("/news")
class NewsReport

@Resource("/messages")
class Messages {
    @Resource("{id}")
    class Id(val parent: Messages = Messages(), val id: Int)
}

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
        get<Messages.Id> { message ->
            call.respondText(
                "Message received:\n${allMessages[message.id]}\non the ${LocalDateTime.now()}",
                status = HttpStatusCode.OK
            )
        }
        get<MainWebPage> {
            call.respondHtml {
                body {
                    this@configureRouting.apply {
                        p {
                            val link: String = href(NewsReport)
                            a(link) { +"Get all news" }
                        }
                        p {
                            val link: String = href(Messages)
                            a(link) { +"Get a all messages" }
                        }
                        p {
                            val link: String = href(Messages.Id)
                            a(link) { +"Read an existing message" }
                        }
                    }
                }
            }
        }
    }
}
