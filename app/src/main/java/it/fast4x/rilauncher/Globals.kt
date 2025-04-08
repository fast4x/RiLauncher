package it.fast4x.rilauncher

import androidx.compose.runtime.Composable
import it.fast4x.rilauncher.ui.styling.LocalAppearance

@Composable
fun typography() = LocalAppearance.current.typography

@Composable
fun colorPalette() = LocalAppearance.current.colorPalette