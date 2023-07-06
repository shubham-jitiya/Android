package com.example.myapplication.webservice.screens.login.viewmodel

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.webservice.screens.login.model.repository.LoginRepository
import com.example.myapplication.webservice.screens.login.model.dataclass.LoginRequest
import com.example.myapplication.webservice.screens.login.model.dataclass.LoginResponse
import com.example.myapplication.webservice.screens.userslist.util.TokenManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val usersListRepository: LoginRepository) : ViewModel() {
    private val _loginTokenLiveData = MutableLiveData<LoginResponse>()
    val token: LiveData<LoginResponse> get() = _loginTokenLiveData
    var username: String? = null
    var password: String? = null

    init {
        username = "eve.holt@reqres.in"
        password = "cityslicka"
    }

    private fun getToken(loginRequest: LoginRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = usersListRepository.login(loginRequest)
            response?.let {
                _loginTokenLiveData.postValue(it)
                TokenManager.token = it.token
            } ?: kotlin.runCatching {
                _loginTokenLiveData.postValue(LoginResponse(""))
                Log.d("TAG", "fetchUserInfo: Response is empty")
            }
        }
    }

    fun validateUser(view: View) {
        val email = username ?: ""
        val password = password ?: ""
        if (email.isNotEmpty() && password.isNotEmpty()) {
            getToken(LoginRequest(email, password))
        }
    }
}