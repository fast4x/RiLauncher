package it.fast4x.rilauncher.enums

import it.fast4x.rilauncher.R

enum class MenuTabs {
    Shortcuts,
    Apps,
    Calls,
    Messages,
    Reminders,
    Settings;

    val index: Int
        get() = when (this) {
            Shortcuts -> 0
            Apps -> 1
            Calls -> 2
            Messages -> 3
            Reminders -> 4
            Settings -> 5
        }

    val icon: Int
    get() = when (this) {
        Shortcuts -> R.drawable.ic_launcher_foreground
        Apps -> R.drawable.ic_launcher_foreground
        Calls -> R.drawable.ic_launcher_foreground
        Messages -> R.drawable.ic_launcher_foreground
        Reminders -> R.drawable.ic_launcher_foreground
        Settings -> R.drawable.ic_launcher_foreground
    }

    val title: String
    get() = when (this) {
        Shortcuts -> "Shortcuts"
        Apps -> "Apps"
        Calls -> "Calls"
        Messages -> "Messages"
        Reminders -> "Reminders"
        Settings -> "Settings"
    }

    val route: NavRoutes
    get() = when (this) {
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