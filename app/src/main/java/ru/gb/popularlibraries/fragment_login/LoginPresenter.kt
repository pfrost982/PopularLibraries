package ru.gb.popularlibraries.fragment_login

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter
import ru.gb.popularlibraries.fragment_greetings.GreetingsScreen

class LoginPresenter(private val router: Router) : MvpPresenter<LoginView>() {
    private var savedUsername: String = "username@mail.com"
    private var savedPassword: String = "***"
    private val EMAIL_REGEX = "^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})"

    override fun attachView(view: LoginView?) {
        super.attachView(view)
        viewState.setLoginText(savedUsername)
        viewState.setPasswordText(savedPassword)
    }

    fun loginClick(username: String, password: String) {
        savedUsername = username
        savedPassword = password
        if (isEmailValid(username)) {
            router.navigateTo(GreetingsScreen(username))
        } else {
            viewState.showLoginFailed("Invalid email")
        }
    }

    private fun isEmailValid(email: String): Boolean = EMAIL_REGEX.toRegex().matches(email)
}