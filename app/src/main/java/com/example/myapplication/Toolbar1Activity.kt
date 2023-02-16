package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityToolbar1Binding

class Toolbar1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityToolbar1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_toolbar1)
    }
}