package listen.components.Music

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.composables.icons.lucide.EllipsisVertical
import com.composables.icons.lucide.Lucide
import kotlinx.serialization.Serializable
import listen.components.Layout.Icon
import java.time.OffsetDateTime
import java.util.*

data class Song(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val album: Album,
    @Serializable(with = OffsetDateTimeSerializer::class)
    val created_at: OffsetDateTime = OffsetDateTime.now(),
)


val songs = listOf<Song>(
    Song(
        name = "U-Fig",
        album = Album(
            name = "Hypnotize",
            image = "https://tse1.explicit.bing.net/th/id/OIP.lfGTNGvda2v6dnf0NB3N-QHaHa?cb=12&rs=1&pid=ImgDetMain&o=7&rm=3",
            artist = Artist(
                name = "System Of A Down",
            )
        ),
    ),

    Song(
        name = "Chop Suey!",
        album = Album(
            name = "Toxicity",
            image = "https://cdn.hmv.com/r/w-1280/hmv/files/d0/d008113d-e164-4902-b359-7002e1ee3be0.jpg",
            artist = Artist(
                name = "System Of A Down",
            )
        ),
    ),

    Song(
        name = "B.Y.O.B.",
        album = Album(
            name = "Mezmerize",
            image = "https://miro.medium.com/v2/resize:fit:1400/1*YZFhF8Rtc3QyZ9HASeNW4A.jpeg",
            artist = Artist(
                name = "System Of A Down",
            )
        ),
    ),

    Song(
        name = "Duality",
        album = Album(
            name = "Vol. 3: (The Subliminal Verses)",
            image = "https://images.genius.com/3fa705c891304f7a7e16cb384b3844f7.1000x1000x1.png",
            artist = Artist(
                name = "Slipknot",
            )
        ),
    ),

    Song(
        name = "Psychosocial",
        album = Album(
            name = "All Hope Is Gone",
            image = "https://i.scdn.co/image/ab67616d00001e02457163bec7e8e4decf8c6375",
            artist = Artist(
                name = "Slipknot",
            )
        ),
    ),

    Song(
        name = "Before I Forget",
        album = Album(
            name = "Vol. 3: (The Subliminal Verses)",
            image = "https://images.genius.com/3fa705c891304f7a7e16cb384b3844f7.1000x1000x1.png",
            artist = Artist(
                name = "Slipknot",
            )
        ),
    ),

    Song(
        name = "Circles",
        album = Album(
            name = "Hollywood's Bleeding",
            image = "https://tse1.explicit.bing.net/th/id/OIP.4hpjcU_nRJC5FYqi8GTlhgHaHa?cb=12&rs=1&pid=ImgDetMain&o=7&rm=3",
            artist = Artist(
                name = "Post Malone",
            )
        ),
    ),

    Song(
        name = "Rockstar",
        album = Album(
            name = "Beerbongs & Bentleys",
            image = "https://www.kolibrimusic.com/wp-content/uploads/2017/09/beerbongs-and-bentleys-2.jpg",
            artist = Artist(
                name = "Post Malone",
            )
        ),
    ),

    Song(
        name = "Sunflower",
        album = Album(
            name = "Spider-Man: Into the Spider-Verse",
            image = "https://tse3.mm.bing.net/th/id/OIP.Lv2fajdg8QjOV44ii3_ZuQHaHa?cb=12&rs=1&pid=ImgDetMain&o=7&rm=3",
            artist = Artist(
                name = "Post Malone",
            )
        ),
    ),

    Song(
        name = "Asa Branca",
        album = Album(
            name = "Luiz Gonzaga e Humberto Teixeira",
            image = "https://cdn1.dustygroove.org/images/products/g/gonzag_luiz_novahisto_101b.jpg",
            artist = Artist(
                name = "Luiz Gonzaga",
            )
        ),
    ),

    Song(
        name = "O Xote das Meninas",
        album = Album(
            name = "O Rei do Baião",
            image = "https://i.scdn.co/image/ab67616d00001e02be0396ceb270a711736faf4d",
            artist = Artist(
                name = "Luiz Gonzaga",
            )
        ),
    )
)


@Composable
fun SongDisplay(song: Song) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxSize().padding(start = 20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
            AsyncImage(
                modifier = Modifier.size(50.dp).clip(RoundedCornerShape(4.dp)),
                contentScale = ContentScale.FillBounds,
                model = song.album.image,
                contentDescription = "${song.album.artist} - ${song.name}"
            )
            Column {
                Text(
                    text = song.name,
                    style = TextStyle(fontWeight = FontWeight.SemiBold, color = Color.White)
                )
                Text(text = song.album.artist.name, style = TextStyle(color = Color(0xFFA1A1A1)))
            }
        }
        Icon(Lucide.EllipsisVertical, "Options", size = 20.dp)

    }
}
