package com.example.myapplication.activity_fragment_intent.uiwidgets

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("TAG", "onCreate: lifecycle second activity")
        binding.buttonThirdActivity.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "onStart: lifecycle second activity")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume: lifecycle second activity")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause: lifecycle second activity")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop: lifecycle second activity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy: lifecycle second activity")
    }

    override fun finish() {
        super.finish()
        Log.d("TAG", "onFinish: lifecycle second activity")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TAG", "onRestart: lifecycle second activity")
    }

    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        Log.d("TAG", "onSaveInstance: lifecycle ")
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d("TAG", "onRestoreInstance: lifecycle ")
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE || newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
            Log.d("TAG", "onConfigurationChanged: lifecycle")
        }
        super.onConfigurationChanged(newConfig)
    }
}