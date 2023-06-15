package com.example.myapplication.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.recyclerview.adapters.NavigationPagerAdapter
import com.example.myapplication.databinding.ActivityImageSliderViewPagerBinding
import com.example.myapplication.recyclerview.fragment.HomeFragment
import com.example.myapplication.recyclerview.fragment.NotificationFragment
import com.example.myapplication.recyclerview.fragment.ProfileFragment
import com.example.myapplication.recyclerview.fragment.SearchFragment
import com.google.android.material.tabs.TabLayoutMediator
import java.util.*

class ImageSliderViewPagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityImageSliderViewPagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageSliderViewPagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupAdapter()
        binding.viewPagerImageSlider.autoScroll(5000, 3000)
    }

    private fun setupAdapter() {
        val adapter = NavigationPagerAdapter(supportFragmentManager, lifecycle)
        adapter.add(HomeFragment())
        adapter.add(SearchFragment())
        adapter.add(NotificationFragment())
        adapter.add(ProfileFragment())
        binding.viewPagerImageSlider.adapter = adapter
        TabLayoutMediator(
            binding.tabLayoutImageSlider,
            binding.viewPagerImageSlider
        ) { _, _ ->
        }.attach()
    }

    private fun ViewPager2.autoScroll(delay: Long, period: Long) {
        Timer().schedule(object : TimerTask() {
            override fun run() {
                binding.viewPagerImageSlider.post {
                    val currentItem = binding.viewPagerImageSlider.currentItem
                    if (currentItem < (adapter?.itemCount ?: 1) - 1) {
                        binding.viewPagerImageSlider.currentItem = currentItem + 1
                    } else {
                        binding.viewPagerImageSlider.currentItem = 0
                    }
                }
            }
        }, delay, period)
    }
}