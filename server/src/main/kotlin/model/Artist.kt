package model

import kotlinx.serialization.Serializable
import java.util.*

@Serializable
data class Artist(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
//    val songs: List<Song>,
//    val albums: List<Album>,
//    val playCount: Int = 0
)