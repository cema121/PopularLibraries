package com.hungryshark.libraries.view.fragments.user_list.adapter

interface IUserItemView : IItemView {
    fun setLogin(text: String)
    fun loadAvatar(url: String)
}