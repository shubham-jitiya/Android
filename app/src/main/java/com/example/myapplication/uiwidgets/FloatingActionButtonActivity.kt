package com.example.myapplication.uiwidgets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityFloatingActionButtonBinding

class FloatingActionButtonActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFloatingActionButtonBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFloatingActionButtonBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fabContacts.shrink()
        binding.fabContacts.setOnClickListener {
            if (binding.fabContacts.isExtended) binding.fabContacts.shrink() else binding.fabContacts.extend()
        }
    }
}