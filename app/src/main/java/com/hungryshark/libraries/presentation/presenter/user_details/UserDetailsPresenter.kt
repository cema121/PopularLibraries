package com.hungryshark.libraries.presentation.presenter.user_details

import com.github.terrakok.cicerone.Router
import com.hungryshark.libraries.data.model.GithubUser
import com.hungryshark.libraries.presentation.view.fragments.user_details.IUserDetailsView
import moxy.MvpPresenter
import javax.inject.Inject

class UserDetailsPresenter : MvpPresenter<IUserDetailsView>() {

    @Inject
    lateinit var router: Router

    var user: GithubUser? = null

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}