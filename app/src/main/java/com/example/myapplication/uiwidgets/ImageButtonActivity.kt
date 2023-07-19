package com.example.myapplication.uiwidgets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityImageButtonBinding

class ImageButtonActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}