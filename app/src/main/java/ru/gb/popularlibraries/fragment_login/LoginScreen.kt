package ru.gb.popularlibraries.fragment_login

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.github.terrakok.cicerone.androidx.FragmentScreen

object LoginScreen: FragmentScreen {
    override fun createFragment(factory: FragmentFactory): Fragment =
        LoginFragment.newInstance()

}