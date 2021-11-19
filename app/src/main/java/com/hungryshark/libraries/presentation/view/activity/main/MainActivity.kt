package com.hungryshark.libraries.presentation.view.activity.main

import android.os.Bundle
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.hungryshark.libraries.R
import com.hungryshark.libraries.data.app.App
import com.hungryshark.libraries.databinding.ActivityMainBinding
import com.hungryshark.libraries.presentation.presenter.main.MainPresenter
import com.hungryshark.libraries.presentation.utils.IBackButtonListener
import moxy.MvpAppCompatActivity
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class MainActivity : MvpAppCompatActivity(), IMainView {

    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private val navigator = AppNavigator(this, R.id.container)

    private val mainPresenter by moxyPresenter {
        MainPresenter().apply {
            App.instance.appComponent.inject(this)
        }
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        App.instance.appComponent.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
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