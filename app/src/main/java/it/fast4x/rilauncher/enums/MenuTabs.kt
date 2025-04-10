package it.fast4x.rilauncher.enums

import it.fast4x.rilauncher.R

enum class MenuTabs {
    Home,
    Shortcuts,
    Apps,
    Calls,
    Messages,
    Reminders,
    Settings;

    val icon: Int
    get() = when (this) {
        Home -> R.drawable.ic_launcher_foreground
        Shortcuts -> R.drawable.ic_launcher_foreground
        Apps -> R.drawable.ic_launcher_foreground
        Calls -> R.drawable.ic_launcher_foreground
        Messages -> R.drawable.ic_launcher_foreground
        Reminders -> R.drawable.ic_launcher_foreground
        Settings -> R.drawable.ic_launcher_foreground
    }

    val title: String
    get() = when (this) {
        Home -> "Home"
        Shortcuts -> "Shortcuts"
        Apps -> "Apps"
        Calls -> "Calls"
        Messages -> "Messages"
        Reminders -> "Reminders"
        Settings -> "Settings"
    }

    val route: NavRoutes
    get() = when (this) {
        Home -> NavRoutes.Home
        Shortcuts -> NavRoutes.Shortcuts
        Apps -> NavRoutes.Apps
        Calls -> NavRoutes.Calls
        Messages -> NavRoutes.Messages
        Reminders -> NavRoutes.Reminders
        Settings -> NavRoutes.Settings
    }

    companion object {
        fun titleOf(index: Int) = MenuTabs.entries[index].title
    }

}