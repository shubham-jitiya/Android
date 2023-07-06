package com.example.myapplication.webservice.screens.login.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentLoginBinding
import com.example.myapplication.webservice.screens.login.model.api.LoginApiService
import com.example.myapplication.webservice.screens.login.model.repository.LoginRepository
import com.example.myapplication.webservice.screens.login.model.api.LoginRetrofitInstance
import com.example.myapplication.webservice.screens.login.viewmodel.LoginViewModel

class LoginFragment : Fragment() {
    private lateinit var binding: FragmentLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_login, container, false)

        initialSetup()
        handleObservers()

        return binding.root
    }

    private fun handleObservers() {
        // login token observer
        viewModel.token.observe(this) {
            if (it != null && it.token.isNotEmpty()) {
                Toast.makeText(context, "Token found: Login successful", Toast.LENGTH_SHORT).show()
                findNavController().navigate(R.id.action_loginFragment_to_usersListFragment)
            } else {
                Toast.makeText(context, "Login unsuccessful: Token not found", Toast.LENGTH_SHORT)
                    .show()
            }
        }
    }

    private fun initialSetup() {
        val apiService = LoginRetrofitInstance.instance.create(LoginApiService::class.java)
        val repository = LoginRepository(apiService)
        viewModel = LoginViewModel(repository)
        binding.viewModel = viewModel
    }
}