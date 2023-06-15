package com.example.myapplication.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.recyclerview.adapters.SimpleListViewAdapter
import com.example.myapplication.databinding.ActivitySimpleListViewBinding
import com.example.myapplication.recyclerview.models.DataSource

class SimpleListViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleListViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.listViewSimple.adapter = SimpleListViewAdapter(this, DataSource().getNames())
    }
}