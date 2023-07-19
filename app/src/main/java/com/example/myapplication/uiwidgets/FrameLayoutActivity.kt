package com.example.myapplication.uiwidgets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityFrameLayoutBinding

class FrameLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFrameLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrameLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}