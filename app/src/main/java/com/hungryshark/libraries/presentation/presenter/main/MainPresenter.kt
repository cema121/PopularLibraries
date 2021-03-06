package com.hungryshark.libraries.presentation.presenter.main

import com.github.terrakok.cicerone.Router
import com.hungryshark.libraries.presentation.utils.screens.IScreens
import com.hungryshark.libraries.presentation.view.activity.main.IMainView
import moxy.MvpPresenter
import javax.inject.Inject

class MainPresenter : MvpPresenter<IMainView>() {

    @Inject
    lateinit var router: Router

    @Inject
    lateinit var screens: IScreens

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.openUserListFragment())
    }

    fun backClicked() {
        router.exit()
    }
}