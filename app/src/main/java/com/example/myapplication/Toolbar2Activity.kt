package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityToolbar2Binding

class Toolbar2Activity : AppCompatActivity() {

    private lateinit var binding: ActivityToolbar2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityToolbar2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
}