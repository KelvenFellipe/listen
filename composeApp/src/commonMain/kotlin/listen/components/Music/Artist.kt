package listen.components.Music

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
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
import kotlinx.serialization.Serializable
import java.time.OffsetDateTime
import java.util.*

@Serializable
data class Artist(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val image: String = "https://placehold.co/400",
    @Serializable(with = OffsetDateTimeSerializer::class)
    val created_at: OffsetDateTime = OffsetDateTime.now(),
)

var artists = listOf(
    Artist(
        name = "System Of A Down",
        image = "https://www.billboard.com/wp-content/uploads/2024/12/System-Of-A-Down-cr-2024-billboard-1548.jpg?w=1024"
    ), Artist(
        name = "Post Malone",
        image = "https://www.rollingstone.com/wp-content/uploads/2023/07/Post-Malone-Album-Review-July-2023.jpg?w=1581&h=1054&crop=1"
    ), Artist(
        name = "Luiz Gonzaga",
        image = "https://mubu.com.br/wp-content/uploads/2023/10/luiz-gonzaga.jpg"
    ), Artist(
        name = "Kanye West",
        image = "https://media1.popsugar-assets.com/files/thumbor/BLJEYz9qkBoHsu2fu9EqYCvafAY/249x163:2149x2063/fit-in/728xorig/filters:format_auto-!!-:strip_icc-!!-/2020/02/24/905/n/1922398/d9c250fc5e5435738e0e78.04534326_/i/Kanye-West.jpg"
    )
)

@Composable
fun ArtistDisplay(artist: Artist) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
        AsyncImage(
            contentScale = ContentScale.Crop,
            model = artist.image,
            contentDescription = artist.name,
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape).aspectRatio(1f).background(Color.LightGray)

        )
        Text(
            text = artist.name,
            style = TextStyle(fontWeight = FontWeight.SemiBold, color = Color.White)
        )
    }
}