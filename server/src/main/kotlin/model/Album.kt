package model

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi
import kotlin.uuid.Uuid

@Serializable
@OptIn(ExperimentalUuidApi::class)
data class Album(
    val id: Uuid = Uuid.random(),
    val name: String,
//    val songs: List<Song>,
    val playCount: Int = 0
)
