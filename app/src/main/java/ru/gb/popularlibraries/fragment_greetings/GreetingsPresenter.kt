package ru.gb.popularlibraries.fragment_greetings

import com.github.terrakok.cicerone.Router
import moxy.MvpPresenter

class GreetingsPresenter(
    private val username: String, private val router: Router
) : MvpPresenter<GreetingsView>() {

    override fun onFirstViewAttach() {
        viewState.setGreetingsText(username)
    }
}