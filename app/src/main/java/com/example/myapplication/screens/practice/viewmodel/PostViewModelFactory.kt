package com.example.myapplication.screens.practice.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.screens.practice.model.repository.PostRepository

class PostViewModelFactory(private val repository: PostRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PostViewModel(repository) as T
    }
}