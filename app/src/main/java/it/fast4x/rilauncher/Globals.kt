package it.fast4x.rilauncher

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import it.fast4x.rilauncher.ui.styling.LocalAppearance

@Composable
fun typography() = LocalAppearance.current.typography

@Composable
fun colorPalette() = LocalAppearance.current.colorPalette