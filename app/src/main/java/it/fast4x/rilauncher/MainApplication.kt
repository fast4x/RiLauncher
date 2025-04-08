package it.fast4x.rilauncher

import android.app.Application
import it.fast4x.rilauncher.utils.CaptureCrash


class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        //Initialize Timber or database or other here

        /**** CRASH LOG *********/
        val dir = filesDir.resolve("logs").also {
            if (it.exists()) return@also
            it.mkdir()
        }
        Thread.setDefaultUncaughtExceptionHandler(
            CaptureCrash(
                dir.absolutePath,
                "RiLauncher_crash_log.txt"
            )
        )
        /**** CRASH LOG *********/
    }
}
