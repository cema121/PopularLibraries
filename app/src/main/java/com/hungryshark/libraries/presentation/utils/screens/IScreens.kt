package com.hungryshark.libraries.presentation.utils.screens

import com.github.terrakok.cicerone.Screen
import com.hungryshark.libraries.data.model.GithubUser

interface IScreens {
    fun openUserListFragment(): Screen
    fun openUserDetailsFragment(user: GithubUser): Screen
}