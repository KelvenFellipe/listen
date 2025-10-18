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

data class Song(
    val name: String,
    val album: String,
    val artist: String,
    val image: String
)

val songs = listOf<Song>(
    Song(
        "U-Fig",
        "Hypnotize",
        "System Of A Down",
        "https://tse1.explicit.bing.net/th/id/OIP.lfGTNGvda2v6dnf0NB3N-QHaHa?cb=12&rs=1&pid=ImgDetMain&o=7&rm=3"
    ),
    Song(
        "Chop Suey!",
        "Toxicity",
        "System Of A Down",
        "https://cdn.hmv.com/r/w-1280/hmv/files/d0/d008113d-e164-4902-b359-7002e1ee3be0.jpg"
    ),
    Song(
        "B.Y.O.B.",
        "Mezmerize",
        "System Of A Down",
        "https://miro.medium.com/v2/resize:fit:1400/1*YZFhF8Rtc3QyZ9HASeNW4A.jpeg"
    ),
    Song(
        "Duality",
        "Vol. 3: (The Subliminal Verses)",
        "Slipknot",
        "https://images.genius.com/3fa705c891304f7a7e16cb384b3844f7.1000x1000x1.png"
    ),
    Song(
        "Psychosocial",
        "All Hope Is Gone",
        "Slipknot",
        "https://i.scdn.co/image/ab67616d00001e02457163bec7e8e4decf8c6375"
    ),
    Song(
        "Before I Forget",
        "Vol. 3: (The Subliminal Verses)",
        "Slipknot",
        "https://images.genius.com/3fa705c891304f7a7e16cb384b3844f7.1000x1000x1.png"
    ),
    Song(
        "Circles",
        "Hollywood's Bleeding",
        "Post Malone",
        "https://tse1.explicit.bing.net/th/id/OIP.4hpjcU_nRJC5FYqi8GTlhgHaHa?cb=12&rs=1&pid=ImgDetMain&o=7&rm=3"
    ),
    Song(
        "Rockstar",
        "Beerbongs & Bentleys",
        "Post Malone",
        "https://www.kolibrimusic.com/wp-content/uploads/2017/09/beerbongs-and-bentleys-2.jpg"
    ),
    Song(
        "Sunflower",
        "Spider-Man: Into the Spider-Verse",
        "Post Malone",
        "https://tse3.mm.bing.net/th/id/OIP.Lv2fajdg8QjOV44ii3_ZuQHaHa?cb=12&rs=1&pid=ImgDetMain&o=7&rm=3"
    ),
    Song(
        "Asa Branca",
        "Luiz Gonzaga e Humberto Teixeira",
        "Luiz Gonzaga",
        "https://cdn1.dustygroove.org/images/products/g/gonzag_luiz_novahisto_101b.jpg"
    ),
    Song(
        "O Xote das Meninas",
        "O Rei do Baião",
        "Luiz Gonzaga",
        "https://i.scdn.co/image/ab67616d00001e02be0396ceb270a711736faf4d"
    )
)


@Composable
fun SongDisplay(song: Song) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AsyncImage(
            modifier = Modifier.size(40.dp).clip(RoundedCornerShape(4.dp)),
            contentScale = ContentScale.FillBounds,
            model = song.image,
            contentDescription = "${song.artist} - ${song.name}"
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(
                text = song.name,
                style = TextStyle(fontWeight = FontWeight.SemiBold, color = Color.White)
            )
            Text(text = song.artist, style = TextStyle(color = Color(0xFFA1A1A1)))
        }
    }
}