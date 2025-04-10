package it.fast4x.rilauncher.ui.components.themed

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.Indication
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun IconButton(
    onClick: () -> Unit,
    @DrawableRes icon: Int,
    color: Color,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    indication: Indication? = null,
    size: Dp = 24.dp
) {
    Image(
        painter = painterResource(icon),
        contentDescription = null,
        colorFilter = ColorFilter.tint(color),
        modifier = Modifier
            .size(size)
            .clickable(
                indication = indication ?: ripple(bounded = false),
                interactionSource = remember { MutableInteractionSource() },
                enabled = enabled,
                onClick = onClick
            )
            .then(modifier)
    )
}