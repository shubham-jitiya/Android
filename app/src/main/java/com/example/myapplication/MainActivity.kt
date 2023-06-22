package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.uiwidgets.UIWidgetsActivity
import com.example.myapplication.recyclerview.*
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.activity_fragment_intent.FragmentDemoCommunicationActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonUIWidgets.setOnClickListener {
            val intent = Intent(this, UIWidgetsActivity::class.java)
            startActivity(intent)
        }

        binding.buttonRecyclerView.setOnClickListener {
            val intent = Intent(this, RecyclerViewDemoActivity::class.java)
            startActivity(intent)
        }

        binding.buttonFragment.setOnClickListener {
            val intent = Intent(this, FragmentDemoCommunicationActivity::class.java)
            startActivity(intent)
        }
    }
}