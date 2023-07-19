package com.example.myapplication.recyclerview

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.R
import com.example.myapplication.recyclerview.adapters.NavigationPagerAdapter
import com.example.myapplication.databinding.ActivitySimpleBottomNavigationBinding
import com.example.myapplication.recyclerview.fragment.HomeFragment
import com.example.myapplication.recyclerview.fragment.NotificationFragment
import com.example.myapplication.recyclerview.fragment.ProfileFragment
import com.example.myapplication.recyclerview.fragment.SearchFragment

class SimpleBottomNavigationActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySimpleBottomNavigationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySimpleBottomNavigationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavigationPagerAdapter()
    }

    private fun setupNavigationPagerAdapter() {
        val adapter = NavigationPagerAdapter(supportFragmentManager, lifecycle)
        adapter.add(HomeFragment())
        adapter.add(SearchFragment())
        adapter.add(NotificationFragment())
        adapter.add(ProfileFragment())
        binding.viewPagerNavigation.adapter = adapter
        binding.bottomNavigation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menuItemHome -> {
                    binding.viewPagerNavigation.currentItem = 0
                    true
                }
                R.id.menuItemSearch -> {
                    binding.viewPagerNavigation.currentItem = 1
                    true
                }
                R.id.menuItemNotification -> {
                    binding.viewPagerNavigation.currentItem = 2
                    true
                }
                else -> {
                    binding.viewPagerNavigation.currentItem = 3
                    true
                }
            }
        }

        binding.viewPagerNavigation.registerOnPageChangeCallback(object :
            ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> binding.bottomNavigation.menu.findItem(R.id.menuItemHome).isChecked = true
                    1 -> binding.bottomNavigation.menu.findItem(R.id.menuItemSearch).isChecked =
                        true
                    2 -> binding.bottomNavigation.menu.findItem(R.id.menuItemNotification).isChecked =
                        true
                    3 -> binding.bottomNavigation.menu.findItem(R.id.menuItemProfile).isChecked =
                        true
                }
            }
        })
    }
}