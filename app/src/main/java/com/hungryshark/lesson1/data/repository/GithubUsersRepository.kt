package com.hungryshark.lesson1.data.repository

import com.hungryshark.lesson1.data.model.GithubUser

class GithubUsersRepository {

    private val repository = (0..100).map { GithubUser("login $it") }

    fun getUsers() = repository
}