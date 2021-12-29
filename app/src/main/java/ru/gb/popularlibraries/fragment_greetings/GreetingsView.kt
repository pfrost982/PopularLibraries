package ru.gb.popularlibraries.fragment_greetings

import moxy.MvpView
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface GreetingsView : MvpView {
    fun setGreetingsText(greetings: String)
    fun setNumber(number: Long)
    fun showInvalidNumber(errorString: String)
}
