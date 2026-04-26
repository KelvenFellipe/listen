package listen.components.Screens.Pages

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Library(modifier: Modifier = Modifier) {
    // 1. STATE MANAGEMENT: Controls the visibility of the sheet
    var showBottomSheet by remember { mutableStateOf(false) }

    // 2. SHEET STATE: Manages the sheet's position (e.g., Hidden, Expanded)
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = false // Set to true if you only want Expanded/Hidden states
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier
            .fillMaxSize(), verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(text = "Library", color = Color.White)
        Card(
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surfaceVariant,
            ),
            modifier = Modifier
                .size(width = 240.dp, height = 100.dp)
        ) {
            Text(text = "Hello, world!")
            Button(onClick = { showBottomSheet = true }) {
                Text("Show Modal Bottom Sheet")
            }
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color.Black
        ) {
        }

    }
    if (showBottomSheet) {
        ModalBottomSheet(
            // This is crucial: called when the user taps the scrim or swipes the sheet down
            onDismissRequest = {
                showBottomSheet = false
            },
            sheetState = sheetState,
            dragHandle = {
                // Optional: Use the default drag handle
                BottomSheetDefaults.DragHandle()
            }
        ) {
            // Your custom content for the bottom sheet goes here
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("This is the Bottom Sheet Content", style = MaterialTheme.typography.titleLarge)
                Spacer(Modifier.height(32.dp))

                Button(
                    onClick = {
                        // Programmatically hide the sheet
                        showBottomSheet = false
                    }
                ) {
                    Text("Close Sheet")
                }
                Spacer(Modifier.height(16.dp)) // Add padding for system navigation bars if necessary
            }
        }
    }
}
