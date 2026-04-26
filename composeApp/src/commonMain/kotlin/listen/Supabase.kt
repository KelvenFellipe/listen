package listen

import io.github.jan.supabase.auth.Auth
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.postgrest.query.Columns
import listen.components.Music.Album
import listen.components.Music.Song

val supabase = createSupabaseClient(
    supabaseUrl = "https://wbtdpuzlsjnlgogxaorl.supabase.co",
    supabaseKey = "sb_publishable_1BVdFhyASKM9WIxoIH_PJA_1tCmOZHO"
) {
    install(Auth)
    install(Postgrest)

}

suspend fun fetchAlbum(): List<Album> {
    val columns = Columns.raw(
        """
    id, name, image,created_at, artist:Artists(*)
""".trimIndent()
    )

    return try {
        supabase.from("Albums").select(columns = columns).decodeList()

    } catch (e: Exception) {
        println("Error fetching Album: ${e.message}")
        emptyList()
    }
}

suspend fun fetchSongs(): List<Song> {
    val columns = Columns.raw(
        """
    id, name, image,created_at, artist:Artists(*)
""".trimIndent()
    )

    return try {
        supabase.from("Albums").select(columns = columns).decodeList()

    } catch (e: Exception) {
        println("Error fetching Album: ${e.message}")
        emptyList()
    }
}

//suspend fun addAlbum() {
//    try {
//        supabase.from("Albums").insert().decodeList()
//
//    } catch (e: Exception) {
//        println("Error fetching Album: ${e.message}")
//
//    }
//}