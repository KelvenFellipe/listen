package listen.components.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.composables.icons.lucide.*
import listen.components.Layout.Icon
import listen.components.Screens.Pages.*

//val player = ExoPlayer.Builder(context).build()
@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    var selectedIndex by remember {
        mutableIntStateOf(0)
    }
    val navItemList = listOf(
        NavItem("Home", Lucide.House),
        NavItem("Home", Lucide.Plus),
        NavItem("Home", Lucide.Library),
        NavItem("Home", Lucide.User),
    )
    Scaffold(modifier = Modifier, containerColor = Color.Blue, bottomBar = {
        NavBar(navItemList, selectedIndex, onItemSelected = { index -> selectedIndex = index })


    }, topBar = { DraggableBox() }) { innerPadding ->
        ContentScreen(
            modifier = modifier.padding(0.dp),
            selectedIndex = selectedIndex,
            setSelected = { number -> selectedIndex = number })
    }
}

@Composable
fun ContentScreen(modifier: Modifier = Modifier, selectedIndex: Int, setSelected: (Int) -> Unit) {
    when (selectedIndex) {
        0 -> Home(modifier = modifier, setSelected = setSelected)
        1 -> Add(modifier = modifier)
        2 -> Library(modifier = modifier)
        3 -> Profile(modifier = modifier)
        else -> Content()
    }
}

@Composable
fun NavBar(itemList: List<NavItem>, selectedIndex: Int, onItemSelected: (Int) -> Unit) {
    Column(modifier = Modifier.fillMaxWidth().navigationBarsPadding()) {
        Box(modifier = Modifier.fillMaxWidth().height(1.dp).background(Color(0xff101010)))
        Row(
            modifier = Modifier.fillMaxWidth().height(60.dp).background(Color.Black).padding(horizontal = 40.dp),
            verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween
        ) {
            itemList.forEachIndexed { index, navItem ->
                NavBarItem(item = navItem, selected = selectedIndex == index, onClick = { onItemSelected(index) })
            }
        }
    }
}

@Composable
fun NavBarItem(item: NavItem, selected: Boolean, onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .clickable(onClick = onClick)
            .background(color = if (selected) Color(0xff101010) else Color.Black, shape = RoundedCornerShape(20.dp))
            .padding(10.dp),
    ) {
        Icon(icon = item.icon, description = item.label, selected = selected)
    }
}