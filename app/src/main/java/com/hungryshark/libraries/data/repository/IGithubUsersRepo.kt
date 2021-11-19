package com.hungryshark.libraries.data.repository

import com.hungryshark.libraries.data.model.GithubUser
import io.reactivex.rxjava3.core.Observable

interface IGithubUsersRepo {
    fun getUsers(): Observable<List<GithubUser>>
    fun subscribeOnGithubUsersData(): Observable<List<GithubUser>>
    fun loadUserData()
}