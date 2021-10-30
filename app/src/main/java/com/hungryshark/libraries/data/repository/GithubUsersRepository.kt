package com.hungryshark.libraries.data.repository

import com.hungryshark.libraries.data.model.GithubUser

class GithubUsersRepository {

    private val repository = (0..100).map { GithubUser("login $it") }

    fun getUsers() = repository
}