package com.hungryshark.lesson1.view.activity.main

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.hungryshark.lesson1.R
import com.hungryshark.lesson1.data.app.App
import com.hungryshark.lesson1.databinding.ActivityMainBinding
import com.hungryshark.lesson1.presenter.main.MainPresenter
import com.hungryshark.lesson1.utils.IBackButtonListener
import com.hungryshark.lesson1.utils.screens.Screens
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(), IMainView {

    private val navigator = AppNavigator(this, R.id.container)

    private val mainPresenter by moxyPresenter {
        MainPresenter(
            App.instance.router,
            Screens()
        )
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }

    override fun onBackPressed() {
        supportFragmentManager.fragments.forEach {
            if (it is IBackButtonListener && it.backPressed()) {
                return
            }
        }
        mainPresenter.backClicked()
    }
}