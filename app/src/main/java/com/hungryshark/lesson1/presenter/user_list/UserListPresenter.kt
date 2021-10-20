package com.hungryshark.lesson1.presenter.user_list

import com.hungryshark.lesson1.data.model.GithubUser
import com.hungryshark.lesson1.view.fragments.user_list.adapter.IUserItemView

class UserListPresenter : IUserListPresenter {

    val users = mutableListOf<GithubUser>()

    override var itemClickListener: ((IUserItemView) -> Unit)? = null

    override fun getCount() = users.size

    override fun bindView(view: IUserItemView) {
        val user = users[view.pos]
        view.setLogin(user.login)
    }
}