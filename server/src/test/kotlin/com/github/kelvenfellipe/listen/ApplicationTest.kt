package com.github.kelvenfellipe.listen

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import org.junit.Assert.assertEquals
import org.junit.Test

class ApplicationTest {

    @Test
    fun testRoot() = testApplication() {
        application {
            module()
        }
        val response = client.get("/hey")

        assertEquals(HttpStatusCode.OK, response.status)
        assertEquals("Hello World!", response.bodyAsText())
    }
}