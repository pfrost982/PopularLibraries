package ru.gb.popularlibraries.mvp_counters

import moxy.MvpView
import moxy.viewstate.strategy.OneExecutionStateStrategy
import moxy.viewstate.strategy.SingleStateStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(SingleStateStrategy::class)
interface MainView: MvpView {
    @StateStrategyType(OneExecutionStateStrategy::class)
    fun setButtonText(button: ButtonType, text: String)
}