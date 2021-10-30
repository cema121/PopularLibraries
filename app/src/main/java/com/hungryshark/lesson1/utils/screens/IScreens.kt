package com.hungryshark.lesson1.utils.screens

import com.github.terrakok.cicerone.Screen
import com.hungryshark.lesson1.data.model.GithubUser

interface IScreens {
    fun openUserListFragment(): Screen
    fun openUserDetailsFragment(user: GithubUser): Screen
}