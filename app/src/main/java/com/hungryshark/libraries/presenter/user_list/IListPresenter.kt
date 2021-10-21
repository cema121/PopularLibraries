package com.hungryshark.libraries.presenter.user_list

import com.hungryshark.libraries.view.fragments.user_list.adapter.IItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}