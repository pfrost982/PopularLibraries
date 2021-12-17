package ru.gb.popularlibraries.fragment_login

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.gb.popularlibraries.PopularLibrariesApp.Navigation.savedPassword
import ru.gb.popularlibraries.PopularLibrariesApp.Navigation.savedUsername
import ru.gb.popularlibraries.fragment_greetings.GreetingsScreen

class LoginPresenter(private val router: Router) : MvpPresenter<LoginView>() {
    override fun attachView(view: LoginView?) {
        super.attachView(view)
        viewState.setLoginText(savedUsername)
        viewState.setPasswordText(savedPassword)
    }

    fun loginClick(username: String, password: String) {
        savedUsername = username
        savedPassword = password
        router.navigateTo(GreetingsScreen(username))
    }
}