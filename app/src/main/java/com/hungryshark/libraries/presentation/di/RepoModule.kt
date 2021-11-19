package com.hungryshark.libraries.presentation.di

import com.hungryshark.libraries.data.IDataSource
import com.hungryshark.libraries.data.room.UserDao
import com.hungryshark.libraries.data.repository.IGithubUsersRepo
import com.hungryshark.libraries.data.repository.RetrofitGithubUsersRepo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepoModule {

    @Provides
    @Singleton
    fun usersRepo(api: IDataSource, dao: UserDao): IGithubUsersRepo =
        RetrofitGithubUsersRepo(
            api, dao
        )
}