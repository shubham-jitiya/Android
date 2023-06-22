package com.example.myapplication.activity_fragment_intent.uiwidgets

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityLifecycleBinding

class LifecycleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLifecycleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLifecycleBinding.inflate(layoutInflater)
        val intent = intent
        val userInfo = intent.getBundleExtra("USER_INFO_BUNDLE")
        Log.d("TAG", "onCreate: $userInfo")
        binding.textViewLifecycle.setText(userInfo?.getString("USERNAME"))
        setContentView(binding.root)
    }
}