package model

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable
@OptIn(ExperimentalUuidApi::class)
data class Artist (
    val id: Uuid = Uuid.random(),
    val name: String,
//    val songs: List<Song>,
//    val albums: List<Album>,
    val playCount: Int = 0
)