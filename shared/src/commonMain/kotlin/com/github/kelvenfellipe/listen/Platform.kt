package com.github.kelvenfellipe.listen

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform