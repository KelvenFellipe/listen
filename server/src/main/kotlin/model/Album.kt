package model

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Album(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
//    val songs: List<Song>,
    val playCount: Int = 0
)
