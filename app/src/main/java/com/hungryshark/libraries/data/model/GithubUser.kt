package com.hungryshark.libraries.data.model

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    @Expose val id: String,
    @Expose val login: String? = null,
    @Expose val avatarUrl: String? = null
) : Parcelable