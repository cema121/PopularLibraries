package com.hungryshark.libraries.view.fragments.user_list.fragment

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hungryshark.libraries.data.app.App
import com.hungryshark.libraries.data.repository.GithubUsersRepository
import com.hungryshark.libraries.databinding.FragmentUserListBinding
import com.hungryshark.libraries.presenter.user_list.ScreenUserListPresenter
import com.hungryshark.libraries.utils.IBackButtonListener
import com.hungryshark.libraries.utils.screens.Screens
import com.hungryshark.libraries.view.fragments.user_list.adapter.UserListAdapter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserListFragment : MvpAppCompatFragment(), IUserListView, IBackButtonListener {

    companion object {
        fun newInstance() = UserListFragment()
    }

    private val screenUserListPresenter by moxyPresenter {
        ScreenUserListPresenter(
            GithubUsersRepository(),
            App.instance.router,
            Screens()
        )
    }

    private var userListAdapter: UserListAdapter? = null

    private var binding: FragmentUserListBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FragmentUserListBinding.inflate(inflater, container, false).also {
        binding = it
    }.root

    override fun init() {
        binding?.run {
            this.userList.layoutManager = LinearLayoutManager(context)
            userListAdapter = UserListAdapter(screenUserListPresenter.userListPresenter)
            this.userList.adapter = userListAdapter
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun updateList() {
        userListAdapter?.notifyDataSetChanged()
    }

    override fun backPressed() = screenUserListPresenter.backPressed()

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}