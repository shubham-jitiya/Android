package com.example.myapplication.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityCoordinateLayoutBinding
import com.google.android.material.snackbar.Snackbar

class CoordinateLayoutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoordinateLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoordinateLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fabCoordinatorLayout.setOnClickListener {
            binding.fabCoordinatorLayout.setOnClickListener {
                Snackbar.make(binding.coordinateLayout, "FAB Tapped", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}