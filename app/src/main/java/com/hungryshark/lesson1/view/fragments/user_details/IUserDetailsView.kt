package com.hungryshark.lesson1.view.fragments.user_details

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUserDetailsView : MvpView {
    fun init()
    fun showUserLogin(login: String)
}