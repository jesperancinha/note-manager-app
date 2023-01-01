package org.jesperancinha.manager.note

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.jesperancinha.manager.note.dao.StoryDao
import org.jesperancinha.manager.note.plugins.configureRouting
import org.junit.Test
import kotlin.test.assertEquals

class ApplicationTest {
    fun testRoot() = testApplication {
        application {
            configureRouting(object : StoryDao {})
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }
}