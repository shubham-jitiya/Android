package com.example.myapplication.uiwidgets

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivitySnackbarBinding
import com.google.android.material.snackbar.Snackbar

class SnackbarActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySnackbarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySnackbarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.snackbarDefault.setOnClickListener {
            Snackbar.make(binding.viewSnackbar, "Default snackbar", Snackbar.LENGTH_SHORT).show()
        }
        binding.snackbarWithAction.setOnClickListener {
            val snackbar =
                Snackbar.make(binding.viewSnackbar, "Snackbar with action", Snackbar.LENGTH_SHORT)
            snackbar.setBackgroundTint(applicationContext.getColor(androidx.appcompat.R.color.error_color_material_dark))
            snackbar.setTextColor(applicationContext.getColor(R.color.black))
            snackbar.setActionTextColor(applicationContext.getColor(R.color.black))
            snackbar.setAction("Undo") {
                Toast.makeText(this, "Undo changes", Toast.LENGTH_SHORT).show()
            }.show()
        }
    }
}