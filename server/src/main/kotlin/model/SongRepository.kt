package model

import kotlinx.serialization.Serializable
import kotlin.uuid.ExperimentalUuidApi


@Serializable
@OptIn(ExperimentalUuidApi::class)
data class Songs(
    val songs: List<Song> = listOf(
        Song(
            title = "Spiders",
            artist = Artist(name = "System Of A Down"),
            album = Album(name = "System of a Down")
        ),
        Song(
            title = "Radio/Video",
            artist = Artist(name = "System Of A Down"),
            album = Album(name = "Mezmerize")
        ),
        Song(
            title = "Soldier Side",
            artist = Artist(name = "System Of A Down"),
            album = Album(name = "Hypnotize")
        ),
        Song(
            title = "Aerials",
            artist = Artist(name = "System Of A Down"),
            album = Album(name = "Toxicity")
        ),
        Song(
            title = "B.Y.O.B.",
            artist = Artist(name = "System Of A Down"),
            album = Album(name = "Mezmerize")
        ),
        Song(
            title = "Holy Mountains",
            artist = Artist(name = "System Of A Down"),
            album = Album(name = "Hypnotize")
        ),
        Song(
            title = "Duality",
            artist = Artist(name = "Slipknot"),
            album = Album(name = "Vol. 3: (The Subliminal Verses)")
        )
    )
)


fun Songs.allSongs(): List<Song> = this.songs


fun Songs.songByName(title: String) = this.songs.find {
    it.title.equals(title, ignoreCase = true)
}

fun Songs.songByArtist(artist: String): List<Song> = this.songs.filter {
    it.artist.name.equals(artist, ignoreCase = true)
}

//    fun addSong(song: Song) {
//        if(Songs.songByName(song.title) != null && songByArtist(song.artist.name) != null) {
//            throw IllegalStateException("Cannot duplicate task names!")
//        }
//        songs.add(song)
//    }
