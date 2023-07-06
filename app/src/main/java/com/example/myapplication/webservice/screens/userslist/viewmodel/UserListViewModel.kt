package com.example.myapplication.webservice.screens.userslist.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.webservice.screens.userslist.model.dataclass.CreateUserRequest
import com.example.myapplication.webservice.screens.userslist.model.dataclass.CreateUserResponse
import com.example.myapplication.webservice.screens.userslist.model.dataclass.SingleUser
import com.example.myapplication.webservice.screens.userslist.model.dataclass.UsersList
import com.example.myapplication.webservice.screens.userslist.model.repository.UserListRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserListViewModel(private val repository: UserListRepository) : ViewModel() {
    private val _usersListLiveData = MutableLiveData<UsersList>()
    private val _isLoadingLiveData = MutableLiveData<Boolean>()
    private val _singleUserLiveData = MutableLiveData<SingleUser>()
    private val _createUserLiveData = MutableLiveData<CreateUserResponse>()

    val usersList: LiveData<UsersList> get() = _usersListLiveData
    val isLoading: LiveData<Boolean> get() = _isLoadingLiveData
    val singleUser: LiveData<SingleUser> get() = _singleUserLiveData
    val createUser: LiveData<CreateUserResponse> get() = _createUserLiveData

    fun fetchUsersList(token: String, options: Map<String, Int>) {
        viewModelScope.launch(Dispatchers.IO) {
            _isLoadingLiveData.postValue(true)
            Log.d("TAG", "fetchUsersList observe: <-- fetching started")
            _usersListLiveData.postValue(repository.fetchUsersList(token, options))
            _isLoadingLiveData.postValue(false)
            Log.d("TAG", "fetchUsersList observe: <-- fetching ended")
        }
    }

    fun fetchUserInfo(userId: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.fetchUserInfo(userId)
            response?.let {
                _singleUserLiveData.postValue(it)
            } ?: kotlin.runCatching { Log.d("TAG", "fetchUserInfo: Response is empty") }
        }
    }

    fun createUser(user: CreateUserRequest) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.createUser(user)
            response?.let {
                _createUserLiveData.postValue(it)
            } ?: kotlin.runCatching { Log.d("TAG", "createUser: Response is empty") }
        }
    }
}