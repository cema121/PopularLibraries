package com.hungryshark.libraries.presenter.user_list

import com.github.terrakok.cicerone.Router
import com.hungryshark.libraries.data.repository.IGithubUsersRepo
import com.hungryshark.libraries.utils.screens.IScreens
import com.hungryshark.libraries.view.fragments.user_list.fragment.IUserListView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter

class ScreenUserListPresenter(
    private val uiScheduler: Scheduler,
    private val usersRepo: IGithubUsersRepo,
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
        usersRepo.getUsers()
            .observeOn(uiScheduler)
            .subscribe({ repos ->
                userListPresenter.users.clear()
                userListPresenter.users.addAll(repos)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}