package com.example.myapplication.uiwidgets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityAppBarBinding

class AppBarActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAppBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAppBarBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarCollapsable.setTitleTextColor(resources.getColor(R.color.white))
        addTextToTextView()
    }
    private fun addTextToTextView() {
        binding.textViewCollapsing.text = resources.getString(R.string.dummy_text)
    }
}