package com.example.myapplication.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityToggleBinding

class ToggleActivity : AppCompatActivity() {

    private lateinit var binding: ActivityToggleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityToggleBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.switchCompat.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Log.d("TAG", "onCreate: Checked")
            } else {
                Log.d("TAG", "onCreate: Unchecked")
            }
        }
    }
}