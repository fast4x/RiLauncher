package it.fast4x.rilauncher

import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalRippleConfiguration
import androidx.compose.material3.RippleConfiguration
import androidx.compose.material3.ripple
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.rememberNavController
import com.valentinilk.shimmer.LocalShimmerTheme
import com.valentinilk.shimmer.defaultShimmerTheme
import it.fast4x.rilauncher.enums.ColorPaletteMode
import it.fast4x.rilauncher.enums.ColorPaletteName
import it.fast4x.rilauncher.enums.FontType
import it.fast4x.rilauncher.enums.ThumbnailRoundness
import it.fast4x.rilauncher.ui.styling.Appearance
import it.fast4x.rilauncher.ui.styling.LocalAppearance
import it.fast4x.rilauncher.ui.styling.colorPaletteOf
import it.fast4x.rilauncher.ui.styling.typographyOf
import it.fast4x.rilauncher.utils.applyFontPaddingKey
import it.fast4x.rilauncher.utils.colorPaletteModeKey
import it.fast4x.rilauncher.utils.colorPaletteNameKey
import it.fast4x.rilauncher.utils.enableLayoutDirectionRtlKey
import it.fast4x.rilauncher.utils.fontTypeKey
import it.fast4x.rilauncher.utils.getEnum
import it.fast4x.rilauncher.utils.isLandscape
import it.fast4x.rilauncher.utils.preferences
import it.fast4x.rilauncher.utils.rememberPreference
import it.fast4x.rilauncher.utils.thumbnailRoundnessKey
import it.fast4x.rilauncher.utils.useSystemFontKey

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        startApp()
        super.onCreate(savedInstanceState)
    }

    @OptIn(ExperimentalMaterial3Api::class)
    fun startApp(){
        setContent {
            val systemDarkTheme = isSystemInDarkTheme()
            LaunchedEffect(Unit, systemDarkTheme, isLandscape) {
                enableEdgeToEdge(
                    statusBarStyle = SystemBarStyle.auto(
                        android.graphics.Color.TRANSPARENT,
                        android.graphics.Color.TRANSPARENT,
                    ) { systemDarkTheme },
                    navigationBarStyle = SystemBarStyle.auto(
                        android.graphics.Color.TRANSPARENT,
                        android.graphics.Color.TRANSPARENT,
                    ) { systemDarkTheme }
                )
                val insetsController = WindowCompat.getInsetsController(window, window.decorView)
                insetsController.apply {
                    hide(WindowInsetsCompat.Type.statusBars())
                    hide(WindowInsetsCompat.Type.navigationBars())
                    systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
                }
            }

            val colorPaletteMode by rememberPreference(
                colorPaletteModeKey,
                ColorPaletteMode.Dark
            )
            val lightTheme =
                colorPaletteMode == ColorPaletteMode.Light || (colorPaletteMode == ColorPaletteMode.System && (!isSystemInDarkTheme()))
            var appearance by rememberSaveable(
                !lightTheme,
                stateSaver = Appearance
            ) {
                with(preferences) {
                    val colorPaletteName =
                        getEnum(colorPaletteNameKey, ColorPaletteName.Dynamic)
                    //val colorPaletteMode = getEnum(colorPaletteModeKey, ColorPaletteMode.Dark)
                    val thumbnailRoundness =
                        getEnum(thumbnailRoundnessKey, ThumbnailRoundness.Heavy)
                    val useSystemFont = getBoolean(useSystemFontKey, false)
                    val applyFontPadding = getBoolean(applyFontPaddingKey, false)

                    var colorPalette =
                        colorPaletteOf(colorPaletteName, colorPaletteMode, !lightTheme)

                    val fontType = getEnum(fontTypeKey, FontType.Doto)

                    //setSystemBarAppearance(colorPalette.isDark)

                    mutableStateOf(
                        Appearance(
                            colorPalette = colorPalette,
                            typography = typographyOf(
                                colorPalette.text,
                                useSystemFont,
                                applyFontPadding,
                                fontType
                            ),
                            thumbnailShape = thumbnailRoundness.shape()
                        )
                    )
                }


            }

            val rippleConfiguration =
                remember(appearance.colorPalette.text, appearance.colorPalette.isDark) {
                    RippleConfiguration(color = appearance.colorPalette.text)
                }

            val shimmerTheme = remember {
                defaultShimmerTheme.copy(
                    animationSpec = infiniteRepeatable(
                        animation = tween(
                            durationMillis = 800,
                            easing = LinearEasing,
                            delayMillis = 250,
                        ),
                        repeatMode = RepeatMode.Restart
                    ),
                    shaderColors = listOf(
                        Color.Unspecified.copy(alpha = 0.25f),
                        Color.White.copy(alpha = 0.50f),
                        Color.Unspecified.copy(alpha = 0.25f),
                    ),
                )
            }

            val enableLayoutDirectionRtl by rememberPreference(
                enableLayoutDirectionRtlKey, false)

            CompositionLocalProvider(
                LocalAppearance provides appearance,
                LocalIndication provides ripple(bounded = true),
                LocalRippleConfiguration provides rippleConfiguration,
                LocalShimmerTheme provides shimmerTheme,
                LocalLayoutDirection provides if (enableLayoutDirectionRtl) LayoutDirection.Rtl else LayoutDirection.Ltr,
            ) {

                val navController = rememberNavController()
                Navigation(navController)
            }
        }
    }
}