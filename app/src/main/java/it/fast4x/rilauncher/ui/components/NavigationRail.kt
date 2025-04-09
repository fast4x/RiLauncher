package it.fast4x.rilauncher.ui.components

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.layout
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import it.fast4x.rilauncher.enums.NavigationBarType
import it.fast4x.rilauncher.typography
import it.fast4x.rilauncher.ui.styling.LocalAppearance
import it.fast4x.rilauncher.ui.styling.semiBold
import it.fast4x.rilauncher.utils.isLandscape
import it.fast4x.rilauncher.utils.navigationBarTypeKey
import it.fast4x.rilauncher.utils.rememberPreference


@Composable
inline fun NavigationRail(
    tabIndex: Int,
    crossinline onTabIndexChanged: (Int) -> Unit,
    content: @Composable ColumnScope.(@Composable (Int, String, Int) -> Unit) -> Unit,
) {
    val (colorPalette, typography) = LocalAppearance.current

    val isLandscape = isLandscape

    val navigationBarType by rememberPreference(navigationBarTypeKey, NavigationBarType.IconAndText)


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .verticalScroll(rememberScrollState())
    ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                val transition = updateTransition(targetState = tabIndex, label = null)

                content { index, text, icon ->

                    val textColor by transition.animateColor(label = "") {
                        if (it == index) colorPalette.text else colorPalette.textDisabled
                    }
                    val dothAlpha by transition.animateFloat(label = "") {
                        if (it == index) 1f else 0f
                    }

                    val textContent: @Composable () -> Unit = {
                        if (navigationBarType == NavigationBarType.IconOnly) {
                            /*
                            BasicText(
                                text = "",
                                style = typography.xs.semiBold.center.color(textColor),
                                modifier = Modifier
                                    .padding(horizontal = 16.dp)
                            )
                             */
                        } else {
                            BasicText(
                                text = text,
                                style = TextStyle(
                                    fontSize = typography().xs.semiBold.fontSize,
                                    fontWeight = typography.xs.semiBold.fontWeight,
                                    color = colorPalette.text,
                                ),
                                modifier = Modifier
                                    .vertical(enabled = !isLandscape)
                                    .rotate(if (isLandscape) 0f else -90f)
                                    .padding(horizontal = 16.dp)
                            )
                        }
                    }

                    val iconContent: @Composable () -> Unit = {
                        if (navigationBarType == NavigationBarType.IconOnly) {
                            Image(
                                painter = painterResource(icon),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(textColor),
                                modifier = Modifier
                                    .padding(top = 12.dp, bottom = 12.dp)
                                    .size(32.dp)
                            )
                        } else {
                            Image(
                                painter = painterResource(icon),
                                contentDescription = null,
                                colorFilter = ColorFilter.tint(colorPalette.text),
                                modifier = Modifier
                                    .vertical(enabled = !isLandscape)
                                    .graphicsLayer {
                                        alpha = dothAlpha
                                        translationX = (1f - dothAlpha) * -48.dp.toPx()
                                        rotationZ = if (isLandscape) 0f else -90f
                                    }
                                    .size(24.dp)
                            )
                        }
                    }

                    val contentModifier = Modifier
                        .clip(RoundedCornerShape(24.dp))
                        .clickable(onClick = { onTabIndexChanged(index) })

                    if (isLandscape) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = contentModifier
                                .padding(vertical = 8.dp)
                        ) {
                            iconContent()
                            textContent()
                        }
                    } else {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = contentModifier
                                .padding(horizontal = 8.dp)
                        ) {
                            iconContent()
                            textContent()
                        }
                    }
                }
            }

    }
}

fun Modifier.vertical(enabled: Boolean = true) =
    if (enabled)
        layout { measurable, constraints ->
            val placeable = measurable.measure(constraints.copy(maxWidth = Int.MAX_VALUE))
            layout(placeable.height, placeable.width) {
                placeable.place(
                    x = -(placeable.width / 2 - placeable.height / 2),
                    y = -(placeable.height / 2 - placeable.width / 2)
                )
            }
        } else this
