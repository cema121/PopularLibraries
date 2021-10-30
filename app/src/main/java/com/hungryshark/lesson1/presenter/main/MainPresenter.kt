package com.hungryshark.lesson1.presenter.main

import com.github.terrakok.cicerone.Router
import com.hungryshark.lesson1.utils.screens.IScreens
import com.hungryshark.lesson1.view.activity.main.IMainView
import moxy.MvpPresenter

class MainPresenter(
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<IMainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screens.openUserListFragment())
    }

    fun backClicked() {
        router.exit()
    }
}