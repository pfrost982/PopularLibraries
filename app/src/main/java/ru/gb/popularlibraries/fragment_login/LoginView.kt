package ru.gb.popularlibraries.fragment_login

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface LoginView : MvpView {
    fun setLoginText(login: String)
    fun setPasswordText(password: String)
    fun showLoginFailed(errorString: String)
}
