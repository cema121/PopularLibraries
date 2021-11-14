package com.hungryshark.libraries.presentation.di

import com.hungryshark.libraries.presentation.presenter.main.MainPresenter
import com.hungryshark.libraries.presentation.presenter.user_details.UserDetailsPresenter
import com.hungryshark.libraries.presentation.presenter.user_list.ScreenUserListPresenter
import com.hungryshark.libraries.presentation.view.activity.main.MainActivity
import com.hungryshark.libraries.presentation.view.fragments.user_list.fragment.UserListFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        CiceroneModule::class,
        CacheModule::class,
        ApiModule::class,
        RepoModule::class
    ]
)
interface AppComponent {

    fun inject(mainActivity: MainActivity)
    fun inject(mainPresenter: MainPresenter)
    fun inject(userDetailsPresenter: UserDetailsPresenter)
    fun inject(screenUserListPresenter: ScreenUserListPresenter)
    fun inject(userListFragment: UserListFragment)
}