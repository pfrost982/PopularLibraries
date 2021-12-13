package ru.gb.popularlibraries

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.gb.popularlibraries.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainView {
    private lateinit var binding: ActivityMainBinding
    private val presenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCounter1.setOnClickListener { presenter.counterClick(0) }
        binding.btnCounter2.setOnClickListener { presenter.counterClick(1) }
        binding.btnCounter3.setOnClickListener { presenter.counterClick(2) }
    }

    override fun setButtonText(index: Int, text: String) {
        when (index) {
            0 -> binding.btnCounter1.text = text
            1 -> binding.btnCounter2.text = text
            2 -> binding.btnCounter3.text = text
        }
    }
}