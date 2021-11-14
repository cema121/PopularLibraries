package com.hungryshark.libraries.presentation.utils.screens

import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hungryshark.libraries.data.model.GithubUser
import com.hungryshark.libraries.presentation.view.fragments.user_details.UserDetailsFragment
import com.hungryshark.libraries.presentation.view.fragments.user_list.fragment.UserListFragment

class Screens : IScreens {

    override fun openUserListFragment() =
        FragmentScreen { UserListFragment.newInstance() }

    override fun openUserDetailsFragment(user: GithubUser) =
        FragmentScreen { UserDetailsFragment.newInstance(user) }
}