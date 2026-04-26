package listen.components.Layout

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun Icon(
    icon: ImageVector,
    description: String,
    onClick: () -> Unit = {},
    size: Dp = 20.dp,
    selected: Boolean = false
) {
    val interactionSource = remember { MutableInteractionSource() }
    val isHovered by interactionSource.collectIsHoveredAsState()
    val iconColor by animateColorAsState(
        targetValue = if (isHovered || selected) Color.White else Color(0xffA1A1A1),
        animationSpec = tween(durationMillis = 500)
    )
    Icon(
        imageVector = icon,
        contentDescription = description,
        modifier = Modifier.size(size).hoverable(interactionSource = interactionSource),
        tint = iconColor
    )
}
           