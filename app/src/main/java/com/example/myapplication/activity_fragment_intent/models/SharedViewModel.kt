package com.example.myapplication.activity_fragment_intent.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private var _message = MutableLiveData<String>()
    var message: LiveData<String> = _message

    fun saveMessage(message: String) {
        _message.value = message
    }
}