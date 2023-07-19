package com.example.myapplication.recyclerview

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityRecyclerViewDemoBinding

class RecyclerViewDemoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRecyclerViewDemoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewDemoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        handleClickListeners()
    }

    private fun handleClickListeners() {
        binding.buttonListView.setOnClickListener {
            val intent = Intent(this, SimpleListViewActivity::class.java)
            startActivity(intent)
        }

        binding.buttonRecyclerViewSelection.setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            startActivity(intent)
        }

        binding.buttonExpandableRecyclerView.setOnClickListener {
            val intent = Intent(this, GmailActivity::class.java)
            startActivity(intent)
        }

        binding.buttonSimpleBottomNavigation.setOnClickListener {
            val intent = Intent(this, SimpleBottomNavigationActivity::class.java)
            startActivity(intent)
        }

        binding.buttonImageSlider.setOnClickListener {
            val intent = Intent(this, ImageSliderViewPagerActivity::class.java)
            startActivity(intent)
        }

        binding.buttonDataBinding.setOnClickListener {
            val intent = Intent(this, DataBindingActivity::class.java)
            startActivity(intent)
        }
    }
}