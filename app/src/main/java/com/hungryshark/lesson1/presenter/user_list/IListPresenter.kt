package com.hungryshark.lesson1.presenter.user_list

import com.hungryshark.lesson1.view.fragments.user_list.adapter.IItemView

interface IListPresenter<V : IItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}