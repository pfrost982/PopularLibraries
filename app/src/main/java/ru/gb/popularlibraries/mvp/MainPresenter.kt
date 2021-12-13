package ru.gb.popularlibraries.mvp

import moxy.MvpPresenter
import ru.gb.popularlibraries.models.CountersModel

class MainPresenter : MvpPresenter<MainView>() {

    private val model: CountersModel = CountersModel()

    override fun attachView(view: MainView?) {
        super.attachView(view)
        ButtonType.values().forEach { button ->
            viewState.setButtonText(button, model.getCurrent(button.value).toString())
        }
    }

    fun counterClick(button: ButtonType) {
        val nextValue = model.next(button.value)
        viewState.setButtonText(button, nextValue.toString())
    }
}
