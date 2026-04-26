package listen.components.Music

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RecentSongs(songs: List<Song>) {
    val rows = songs.chunked(4)

    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Recent",
            color = Color.White,
            fontWeight = FontWeight.SemiBold,
            style = TextStyle(fontSize = 20.sp),
            modifier = Modifier.padding(horizontal = 20.dp)
        )
        LazyRow(
            modifier = Modifier.fillMaxWidth(),


            ) {
            items(rows) { row ->

                Column(
                    verticalArrangement = Arrangement.spacedBy(12.dp),
                    // Apply a fixed width equal to the screen width
                    modifier = Modifier.width(width = 350.dp)
                ) {
                    row.forEach { song ->
                        SongDisplay(song)
                    }
                }
            }
        }
//        HorizontalUncontainedCarousel(
//            state = rememberCarouselState { rows.count() },
//            modifier = Modifier
//                .fillMaxWidth()
//                .wrapContentHeight()
//                .padding(top = 16.dp, bottom = 16.dp),
//            itemWidth = 350.dp,
//            itemSpacing = 8.dp,
//            contentPadding = PaddingValues(horizontal = 16.dp)
//        ) { i ->
//            val item = rows[i]
//            LazyColumn(
//                verticalArrangement = Arrangement.spacedBy(8.dp),
//            ) {
//                items(item) { song -> SongDisplay(song) }
//            }
//        }
    }

}


