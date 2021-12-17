package ru.gb.popularlibraries

import android.app.Application
import com.github.terrakok.cicerone.Cicerone

class PopularLibrariesApp : Application() {
    companion object Navigation {
        private val cicerone = Cicerone.create()
        val navigatorHolder = cicerone.getNavigatorHolder()
        val router = cicerone.router

        var savedUsername: String = "usernameApp"
        var savedPassword: String = "passwordApp"
    }
}