package model

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

//enum class Priority {
//    Low, Medium, High, Vital
//}
@Serializable
@OptIn(ExperimentalUuidApi::class)
data class Song(
    val id: Uuid = Uuid.random(),
    val title: String,
    val artist: Artist,
    val album: Album,
    val playCount: Int = 0
)


