package com.example.myapplication.webservice.screens.userslist.view.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentUsersListBinding
import com.example.myapplication.webservice.screens.userslist.adapter.UsersListAdapter
import com.example.myapplication.webservice.screens.userslist.model.api.UsersListApiService
import com.example.myapplication.webservice.screens.userslist.model.api.UsersListRetrofitClient
import com.example.myapplication.webservice.screens.userslist.model.dataclass.CreateUserRequest
import com.example.myapplication.webservice.screens.userslist.model.dataclass.SingleUser
import com.example.myapplication.webservice.screens.userslist.model.repository.UserListRepository
import com.example.myapplication.webservice.screens.userslist.util.NetworkManager
import com.example.myapplication.webservice.screens.userslist.util.NetworkStatus
import com.example.myapplication.webservice.screens.userslist.util.TokenManager
import com.example.myapplication.webservice.screens.userslist.viewmodel.UserListViewModel

class UsersListFragment : Fragment(), UsersListAdapter.OnItemClickListener, OnCreateClickListener {
    private lateinit var binding: FragmentUsersListBinding
    private lateinit var viewModel: UserListViewModel
    private lateinit var networkManagerLiveData: NetworkManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_users_list, container, false)

        initialSetup()
        setupObservers()
        getList()
        binding.fabAddUser.setOnClickListener {
            addUser()
        }

        return binding.root
    }

    private fun getList() {
        val options = HashMap<String, Int>()
        options["per_page"] = 20
        options["delay"] = 3
        viewModel.fetchUsersList(TokenManager.token, options)
    }

    private fun addUser() {
        val dialog = AddUserDialogFragment(this)
        dialog.show(parentFragmentManager, "AddUser")
    }

    private fun setupObservers() {
        // users list observer
        viewModel.usersList.observe(this) {
            Log.d("TAG", "onCreateView: $it")
            val adapter = UsersListAdapter(this, ArrayList())
            viewModel.usersList.value?.data?.let { data ->
                adapter.submitList(data)
            }
            binding.recyclerViewUsersList.adapter = adapter
        }
        // progress bar observer
        viewModel.isLoading.observe(this) {
            if (it == true) {
                Log.d("TAG", "setupObservers: loading started")
                binding.progressBarUsersList.show()
            } else {
                Log.d("TAG", "setupObservers: loading ended")
                binding.progressBarUsersList.hide()
                // load adapter
            }
        }
        // selected  user info observer
        viewModel.singleUser.observe(this) {
            Log.d("TAG", "setupObservers: $it")
            showDialog(it)
        }
        // create user observer
        viewModel.createUser.observe(this) {
            it?.let {
                Toast.makeText(
                    requireContext(),
                    "User created successfully with id: ${it.id}",
                    Toast.LENGTH_SHORT
                ).show()
            }
                ?: kotlin.runCatching {
                    Toast.makeText(
                        requireContext(),
                        "Failed! While creating new user",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        }
        // internet connectivity observer
        networkManagerLiveData.observe(this) { status ->
            when (status) {
                is NetworkStatus.Disconnected ->
                    Toast.makeText(
                        context,
                        "Please check your internet connectivity",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                else -> {}
            }
        }
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("TAG", "onDetach: ")
    }

    private fun showDialog(userInfo: SingleUser) {
        val dialog = SingleUserDialogFragment(userInfo)
        dialog.show(parentFragmentManager, "UserInfoDialog")
    }

    private fun initialSetup() {
        val apiProvider = UsersListRetrofitClient.instance.create(UsersListApiService::class.java)
        val repository = UserListRepository(apiProvider)
        viewModel = UserListViewModel(repository)
        networkManagerLiveData = NetworkManager(requireContext())
    }

    override fun onItemClick(userId: Int) {
        viewModel.fetchUserInfo(userId)
    }

    override fun onClickSubmitUserInfo(name: String, job: String) {
        viewModel.createUser(CreateUserRequest(name = name, job = job))
    }
}