package it.fast4x.rilauncher

import androidx.compose.runtime.Composable
import it.fast4x.rilauncher.enums.NavigationBarType
import it.fast4x.rilauncher.ui.styling.LocalAppearance
import it.fast4x.rilauncher.utils.navigationBarTypeKey
import it.fast4x.rilauncher.utils.rememberPreference

@Composable
fun typography() = LocalAppearance.current.typography

@Composable
fun colorPalette() = LocalAppearance.current.colorPalette

@Composable
fun navigationBarType() = rememberPreference(navigationBarTypeKey, NavigationBarType.IconAndText)

@Composable
fun thumbnailRoundness() = LocalAppearance.current.thumbnailShape