package ru.gb.popularlibraries

import android.os.Bundle
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import ru.gb.popularlibraries.databinding.ActivityMainCountersBinding
import ru.gb.popularlibraries.mvp_counters.ButtonType
import ru.gb.popularlibraries.mvp_counters.MainPresenter
import ru.gb.popularlibraries.mvp_counters.MainView

class MainActivityCounters : MvpAppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainCountersBinding

    private val presenter by moxyPresenter {
        MainPresenter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainCountersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCounter1.setOnClickListener { presenter.counterClick(ButtonType.FIRST_BUTTON) }
        binding.btnCounter2.setOnClickListener { presenter.counterClick(ButtonType.SECOND_BUTTON) }
        binding.btnCounter3.setOnClickListener { presenter.counterClick(ButtonType.THIRD_BUTTON) }
    }

    override fun setButtonText(button: ButtonType, text: String) {
        when (button) {
            ButtonType.FIRST_BUTTON -> binding.btnCounter1.text = text
            ButtonType.SECOND_BUTTON -> binding.btnCounter2.text = text
            ButtonType.THIRD_BUTTON -> binding.btnCounter3.text = text
        }
    }
}