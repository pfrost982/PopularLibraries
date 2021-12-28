package ru.gb.popularlibraries.fragment_greetings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.popularlibraries.PopularLibrariesApp.Navigation.router
import ru.gb.popularlibraries.databinding.FragmentGreetingsBinding

class GreetingsFragment : MvpAppCompatFragment(), GreetingsView {
    private val username: String by lazy {
        arguments?.getString(USER_NAME_VALUE).orEmpty()
    }

    companion object {
        private const val USER_NAME_VALUE = "ARG_USER_NAME_VALUE"

        fun newInstance(username: String): Fragment =
            GreetingsFragment().apply {
                arguments = Bundle().apply {
                    putString(USER_NAME_VALUE, username)
                }
            }
    }

    private val presenter: GreetingsPresenter by moxyPresenter {
        GreetingsPresenter(username, router)
    }

    private var _binding: FragmentGreetingsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGreetingsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun setGreetingsText(greetings: String) {
        binding.greetingsText.text = greetings
    }

    override fun setNumber(number: Long) {
        binding.numberEditText.setText(number.toString())
    }
}