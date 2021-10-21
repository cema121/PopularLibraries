package com.hungryshark.libraries.view.fragments.user_list.fragment

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle

@AddToEndSingle
interface IUserListView : MvpView {
    fun init()
    fun updateList()
}