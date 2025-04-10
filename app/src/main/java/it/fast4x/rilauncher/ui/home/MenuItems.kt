package it.fast4x.rilauncher.ui.home

import androidx.compose.runtime.Composable
import it.fast4x.rilauncher.enums.MenuTabs
import it.fast4x.rilauncher.enums.NavRoutes

@Composable
fun MenuItems(item: @Composable ((Int, String, Int, NavRoutes) -> Unit)) {
    MenuTabs.entries.forEach {
        item(it.ordinal, it.name, it.icon, it.route)
    }
}