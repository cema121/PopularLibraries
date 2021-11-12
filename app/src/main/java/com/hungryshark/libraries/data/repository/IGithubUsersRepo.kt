package com.hungryshark.libraries.data.repository

import com.hungryshark.libraries.data.model.GithubUser
import io.reactivex.rxjava3.core.Single

interface IGithubUsersRepo {
    fun getUsers(): Single<List<GithubUser>>
}