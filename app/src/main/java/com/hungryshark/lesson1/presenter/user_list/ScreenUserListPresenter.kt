package com.hungryshark.lesson1.presenter.user_list

import com.github.terrakok.cicerone.Router
import com.hungryshark.lesson1.data.repository.GithubUsersRepository
import com.hungryshark.lesson1.utils.screens.IScreens
import com.hungryshark.lesson1.view.fragments.user_list.fragment.IUserListView
import moxy.MvpPresenter

class ScreenUserListPresenter(
    private val githubUsersRepository: GithubUsersRepository,
    private val router: Router,
    private val screens: IScreens
) : MvpPresenter<IUserListView>() {

    val userListPresenter = UserListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        userListPresenter.itemClickListener = { itemView ->
            val user = userListPresenter.users[itemView.pos]
            router.navigateTo(screens.openUserDetailsFragment(user))
        }
    }

    private fun loadData() {
        val users = githubUsersRepository.getUsers()
        userListPresenter.users.addAll(users)
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}