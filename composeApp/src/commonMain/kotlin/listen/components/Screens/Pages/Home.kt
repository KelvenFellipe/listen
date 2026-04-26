package listen.components.Screens.Pages

import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import listen.components.Layout.Header
import listen.components.Music.*
import kotlin.math.roundToInt

@Composable
fun Home(modifier: Modifier = Modifier, setSelected: (Int) -> Unit = {}) {
    LazyColumn(
        modifier = modifier.fillMaxSize().background(Color.Black).padding(bottom = 80.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item { Header() }
        item { RecentSongs(songs) }
        item { LikedArtists(artists) }
        item { LikedAlbums(setSelected = setSelected) }


    }

}

@Composable
fun DraggableBox() {
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .offset { IntOffset(offsetX.roundToInt(), offsetY.roundToInt()) }
            .size(150.dp)
            .background(Color.Red, shape = RoundedCornerShape(12.dp))
            .zIndex(1f) // Ensures it's drawn above other elements
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    change.consume()
                    offsetX += dragAmount.x
                    offsetY += dragAmount.y
                }
            }
    )
}