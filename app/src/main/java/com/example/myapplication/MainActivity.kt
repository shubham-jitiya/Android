package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
//        supportActionBar?.hide()

        binding.btnToolbar1.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(this, Toolbar1Activity::class.java)
            startActivity(intent)
        })
        binding.btnToolbar2.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(this, Toolbar2Activity::class.java)
            startActivity(intent)
        })
        binding.btnToolbar3.setOnClickListener(View.OnClickListener { view ->
            val intent = Intent(this, Toolbar3Activity::class.java)
            startActivity(intent)
        })
    }

}