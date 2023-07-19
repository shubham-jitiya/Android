package com.example.myapplication.uiwidgets

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityFrameLayoutManagerBinding
import com.example.myapplication.uiwidgets.fragments.CallsFragment
import com.example.myapplication.uiwidgets.fragments.ChatsFragment
import com.example.myapplication.uiwidgets.fragments.FirstFragment
import com.example.myapplication.uiwidgets.fragments.StatusFragment

class FrameLayoutManagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFrameLayoutManagerBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFrameLayoutManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFragmentFirst.setOnClickListener {
            replaceFragment(ChatsFragment())
        }
        binding.btnFragmentSecond.setOnClickListener {
            replaceFragment(StatusFragment())
        }
        binding.btnFragmentThird.setOnClickListener {
            replaceFragment(CallsFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameFragment, fragment)
        fragmentTransaction.commit()
    }
}