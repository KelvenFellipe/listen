package com.github.kelvenfellipe.listen

import io.ktor.http.ContentType
import io.ktor.http.HttpStatusCode
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.http.content.staticResources
import io.ktor.server.netty.*
import io.ktor.server.request.receiveParameters
import io.ktor.server.response.*
import io.ktor.server.routing.*
import model.*
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

val songList = Songs()
@OptIn(ExperimentalUuidApi::class)
fun Application.configureRouting() {
    routing {
        staticResources("static", "static")


        get("/") {
            call.respondText("This is a test")
        }
        get("/hey") {
            call.respondText("Hello World!")
        }


        get ("/songs"){
            call.respond(songList.allSongs())
        }
            get("/songs/byArtist/{artist?}"){
                val artist = call.parameters["artist"]
                if (artist == null){
                    call.respond(HttpStatusCode.BadRequest)
                    return@get
                }

                try{
                    val artistSongs = Songs().songByArtist(artist)

                    if (artistSongs.isEmpty()){
                        call.respond(HttpStatusCode.NotFound)
                        return@get
                    }

                    call.respond(artistSongs)
                }
                catch (ex: IllegalArgumentException){
                    call.respond(HttpStatusCode.BadRequest)
                }
            }
//            post {
//                val formContent = call.receiveParameters()
//
//                val params = Triple(
//                    formContent["name"] ?: "",
//                    formContent["description"] ?: "",
//                    formContent["priority"] ?: ""
//                )
//
//                if (params.toList().any { it.isEmpty() }) {
//                    call.respond(HttpStatusCode.BadRequest)
//                    return@post
//                }
//
//                try {
//                    val priority = Priority.valueOf(params.third)
//                    TaskRepository.addTask(
//                        Task(
//                            params.first,
//                            params.second,
//                            priority
//                        )
//                    )
//
//                    call.respond(HttpStatusCode.NoContent)
//                } catch (ex: IllegalArgumentException) {
//                    call.respond(HttpStatusCode.BadRequest)
//                } catch (ex: IllegalStateException) {
//                    call.respond(HttpStatusCode.BadRequest)
//                }
//            }


    }
}