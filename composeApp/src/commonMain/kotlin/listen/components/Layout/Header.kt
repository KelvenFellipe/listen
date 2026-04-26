package listen.components.Layout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.Lucide
import com.composables.icons.lucide.Search
import listen.composeapp.generated.resources.Res
import listen.composeapp.generated.resources.logo
import org.jetbrains.compose.resources.painterResource

@Composable
fun Header() {

    Row(
        modifier = Modifier.fillMaxWidth().padding(20.dp),
        Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(Res.drawable.logo),
            contentDescription = null, modifier = Modifier.size(32.dp)

        )
        Icon(
            Lucide.Search,
            "Search Icon",
            size = 20.dp
        )
    }
}