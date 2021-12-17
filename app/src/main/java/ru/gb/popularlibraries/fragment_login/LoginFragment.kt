package ru.gb.popularlibraries.fragment_login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter
import ru.gb.popularlibraries.PopularLibrariesApp.Navigation.router
import ru.gb.popularlibraries.databinding.FragmentLoginBinding

class LoginFragment : MvpAppCompatFragment(), LoginView {
    companion object {
        fun newInstance(): Fragment = LoginFragment()
    }

    private val presenter: LoginPresenter by moxyPresenter {
        LoginPresenter(router)
    }

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.login.setOnClickListener {
            presenter.loginClick(binding.username.text.toString(), binding.password.text.toString())
        }
    }

    private fun showLoginFailed(errorString: String) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun setLoginText(login: String) {
        binding.username.setText(login)
    }

    override fun setPasswordText(password: String) {
        binding.password.setText(password)
    }
}