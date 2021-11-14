package com.hungryshark.libraries.presentation.presenter.user_list

import com.hungryshark.libraries.presentation.view.fragments.user_list.adapter.IItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}