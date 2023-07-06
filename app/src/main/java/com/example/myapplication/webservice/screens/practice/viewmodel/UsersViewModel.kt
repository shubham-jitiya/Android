package com.example.myapplication.webservice.screens.practice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.webservice.screens.practice.model.repository.UserRepository
import com.example.myapplication.webservice.screens.userslist.model.dataclass.UsersList
import kotlinx.coroutines.launch

class UsersViewModel(private val usersRepository: UserRepository): ViewModel() {
    private val _usersList = MutableLiveData<UsersList>()
    val usersList: LiveData<UsersList>
    get() = _usersList

    fun fetchUsers()  {
        viewModelScope.launch {
           _usersList.postValue(usersRepository.getUsers())
        }
    }
}