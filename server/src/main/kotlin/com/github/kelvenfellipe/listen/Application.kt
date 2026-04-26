package com.github.kelvenfellipe.listen

import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    val supabase = createSupabaseClient(
        supabaseUrl = "https://wbtdpuzlsjnlgogxaorl.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6IndidGRwdXpsc2pubGdvZ3hhb3JsIiwicm9sZSI6ImFub24iLCJpYXQiOjE3NTkyNjc2OTIsImV4cCI6MjA3NDg0MzY5Mn0.IPM0Ol1aMnqPNUJ43wdw0U7ua_34UG91-i8Bcmt9pgI"
    ) {
        install(Postgrest)
    }
    configureSerialization()
    configureRouting()
}