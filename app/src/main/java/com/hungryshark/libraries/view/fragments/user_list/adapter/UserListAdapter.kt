package com.hungryshark.libraries.view.fragments.user_list.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.hungryshark.libraries.data.IImageLoader
import com.hungryshark.libraries.databinding.ItemUserBinding
import com.hungryshark.libraries.presenter.user_list.IUserListPresenter

class UserListAdapter(
    private val mainPresenter: IUserListPresenter,
    val imageLoader: IImageLoader<ImageView>
) : RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    inner class ViewHolder(
        private val binding: ItemUserBinding
    ) : RecyclerView.ViewHolder(binding.root), IUserItemView {

        override var pos = -1
        override fun setLogin(text: String) = with(binding) {
            loginUserList.text = text
        }

        override fun loadAvatar(url: String) = with(binding) {
            imageLoader.loadInto(url, binding.avatarUserList)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ItemUserBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        ).apply {
            itemView.setOnClickListener { mainPresenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = mainPresenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        mainPresenter.bindView(holder.apply { pos = position })
}