package listen


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import org.jetbrains.compose.ui.tooling.preview.Preview


data class Animal(val genus: String, val species: String, val picture: String) {
}

val triceratops = Animal("triceratops", "horridus", "https://cdn.mos.cms.futurecdn.net/Fxqy87tW7XcdNnxd8qJzcT.jpg")

@Composable
@Preview
fun App(triceratops: Animal) {

    Column {
        Text("This is test")
        Text("This is test")
        Text("This is test")
    }
}

@Composable
fun AnimalCard(animal: Animal) {
    Column {
        AsyncImage(
            modifier = Modifier.height(200.dp), model = animal.picture, contentDescription = animal.genus
        )
        Column {
            Text(animal.genus)
            Text(animal.species)
        }
    }
}