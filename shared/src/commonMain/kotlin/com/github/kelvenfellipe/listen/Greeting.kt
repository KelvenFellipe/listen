package com.github.kelvenfellipe.listen

@kotlin.js.JsExport
class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ass!"
    }
}