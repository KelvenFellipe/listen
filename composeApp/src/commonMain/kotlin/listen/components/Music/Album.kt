package listen.components.Music

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import java.time.OffsetDateTime
import java.util.*

@Serializable
data class Album(
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val artist: Artist,
    val image: String = "https://placehold.co/400",
    @Serializable(with = OffsetDateTimeSerializer::class)
    val created_at: OffsetDateTime = OffsetDateTime.now(),
)

object OffsetDateTimeSerializer : KSerializer<OffsetDateTime> {
    override val descriptor = PrimitiveSerialDescriptor("OffsetDateTime", PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: OffsetDateTime) {
        encoder.encodeString(value.toString())
    }

    override fun deserialize(decoder: Decoder): OffsetDateTime {
        return OffsetDateTime.parse(decoder.decodeString())
    }
}

@Composable
fun AlbumDisplay(album: Album, setSelected: (Int) -> Unit = {}) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(8.dp), modifier = Modifier.clickable(onClick = { setSelected(4) })
    ) {
        AsyncImage(
            contentScale = ContentScale.Crop,
            model = album.image,
            contentDescription = album.name,
            modifier = Modifier
                .size(160.dp)
                .aspectRatio(1f).background(Color.LightGray)

        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = album.name,
                style = TextStyle(fontWeight = FontWeight.SemiBold, color = Color.White)
            )
            Text(text = album.artist.name, style = TextStyle(color = Color(0xFFA1A1A1)))
        }
    }
}
