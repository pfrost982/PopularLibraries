package ru.gb.popularlibraries

import android.R
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.terrakok.cicerone.androidx.AppNavigator
import ru.gb.popularlibraries.PopularLibrariesApp.Navigation.navigatorHolder
import ru.gb.popularlibraries.PopularLibrariesApp.Navigation.router
import ru.gb.popularlibraries.fragment_login.LoginScreen

class MainActivity : AppCompatActivity() {
    private val navigator = AppNavigator(activity = this, R.id.content)

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            router.navigateTo(LoginScreen)
        }
    }

    override fun onPause() {
        navigatorHolder.removeNavigator()
        super.onPause()
    }
}