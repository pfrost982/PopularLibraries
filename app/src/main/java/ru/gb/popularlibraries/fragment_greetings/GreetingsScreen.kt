package ru.gb.popularlibraries.fragment_greetings

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

class GreetingsScreen(private val username: String): FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        GreetingsFragment.newInstance(username)
}