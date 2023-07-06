package com.example.myapplication.webservice.screens.practice.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.webservice.screens.practice.model.dataclass.Post
import com.example.myapplication.webservice.screens.practice.model.repository.PostRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PostViewModel(private val postRepository: PostRepository) : ViewModel() {
    private val _specificPost = MutableLiveData<Post>()
    private val _posts = MutableLiveData<ArrayList<Post>>()
    private val _postResponse = MutableLiveData<Post>()

    val specificPost: LiveData<Post> get() = _specificPost
    val posts: LiveData<ArrayList<Post>> get() = _posts
    val postResponse: LiveData<Post> get() = _postResponse

    fun getSpecificPost(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            val resultData = postRepository.getPostById(id)
            resultData?.let {
                _specificPost.postValue(it)
            }
        }
    }

    fun getPosts() {
        this.viewModelScope.launch(Dispatchers.IO) {
            _posts.postValue(postRepository.getAllPosts())
        }
    }

    fun pushPost(post: Post) {
        this.viewModelScope.launch(Dispatchers.IO) {
            _postResponse.postValue(postRepository.pushPost(post))
        }
    }

    fun pushEncryptedPost(post: Post) {
        this.viewModelScope.launch(Dispatchers.IO) {
            _postResponse.postValue(postRepository.pushEncryptedPost(post))
        }
    }

    fun searchPost(userId: Int) {
        this.viewModelScope.launch(Dispatchers.IO) {
            _posts.postValue(postRepository.searchPost(userId))
        }
    }

    fun sortPost(userId: Int, sort: String, order: String) {
        this.viewModelScope.launch(Dispatchers.IO) {
            _posts.postValue(postRepository.sortPost(userId, sort, order))
        }
    }

    fun sortPostByMap(userId: Int, options: Map<String, String>) {
        this.viewModelScope.launch(Dispatchers.IO) {
            _posts.postValue(postRepository.sortPostByMap(userId, options))

        }
    }

    fun fetchWithOkHttp() {
        postRepository.getWithOKHttp()
    }
}