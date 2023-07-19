package com.example.myapplication.uiwidgets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityGridLayoutProjectBinding

class GridLayoutProjectActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGridLayoutProjectBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGridLayoutProjectBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}