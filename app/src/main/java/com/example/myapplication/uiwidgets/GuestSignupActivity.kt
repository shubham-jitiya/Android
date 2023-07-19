package com.example.myapplication.uiwidgets

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityGuestSignupBinding
import com.example.myapplication.uiwidgets.adapter.AccountTypeViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class GuestSignupActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGuestSignupBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGuestSignupBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbarGuestSignup.setNavigationOnClickListener {
            Log.d("TAG", "onCreate: back")
            finish()
        }
        setupTabLayout()
    }

    private fun setupTabLayout() {
        val tabs = arrayOf("Personal", "Business")
        val adapter = AccountTypeViewPagerAdapter(supportFragmentManager, lifecycle)
        binding.viewPagerSignupDetails.adapter = adapter
        TabLayoutMediator(
            binding.tabLayoutAccountType,
            binding.viewPagerSignupDetails
        ) { tab, position ->
            tab.text = tabs[position]
        }.attach()
    }
}