package com.example.myapplication.screens.practice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.screens.userslist.model.dataclass.UsersList
import com.example.myapplication.screens.practice.model.repository.UserRepository
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