package com.example.myapplication.uiwidgets.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myapplication.uiwidgets.fragments.LocationDetailsBusinessFragment
import com.example.myapplication.uiwidgets.fragments.LocationDetailsPersonalFragment

private const val TABS = 2

class LocationDetailsViewPagerAdapter(fragment: FragmentManager, lifecycle: Lifecycle) :
    FragmentStateAdapter(fragment, lifecycle) {
    override fun getItemCount(): Int {
        return TABS
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> LocationDetailsPersonalFragment()
            else -> LocationDetailsBusinessFragment()
        }
    }
}