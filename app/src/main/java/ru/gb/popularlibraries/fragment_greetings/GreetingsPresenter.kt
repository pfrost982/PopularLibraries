package ru.gb.popularlibraries.fragment_greetings

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import io.reactivex.rxjava3.subjects.PublishSubject
import moxy.MvpPresenter

class GreetingsPresenter(private val username: String) : MvpPresenter<GreetingsView>() {

    private val subject: PublishSubject<Long> = PublishSubject.create()
    private val disposable = subject
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .map { it * it }
        .subscribe { viewState.setNumber(it) }

    override fun onFirstViewAttach() {
        viewState.setGreetingsText(username)
    }

    fun calculate(number: String) {
        if (number.isEmpty()) {
            viewState.showInvalidNumber("Invalid number")
        } else {
            subject.onNext(number.toLong())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        disposable.dispose()
    }
}