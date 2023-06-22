package com.example.myapplication.activity_fragment_intent.uiwidgets

import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityThirdBinding

class ThirdActivity : AppCompatActivity() {
    private lateinit var binding: ActivityThirdBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getActivitiesInStack()
    }

    private fun getActivitiesInStack() {
        val activities = packageManager
            .getPackageInfo(packageName, PackageManager.GET_ACTIVITIES).activities
        val nameList = activities.map { it.name }
        Log.d("TAG", "getActivitiesInStack: $nameList")
    }
}