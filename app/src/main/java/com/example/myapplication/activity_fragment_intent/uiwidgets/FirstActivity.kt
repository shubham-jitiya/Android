package com.example.myapplication.activity_fragment_intent.uiwidgets

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityFirstBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Log.d("TAG", "onCreate: lifecycle ")
        binding.buttonSecondActivity.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            Log.d("TAG", "onCreate: lifecycle: goto second activity")
            startActivity(intent)
            // finish()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG", "onStart: lifecycle first activity")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG", "onResume: lifecycle first activity")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG", "onPause: lifecycle first activity")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG", "onStop: lifecycle first activity")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG", "onDestroy: lifecycle first activity")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TAG", "onRestart: lifecycle first activity")
    }

    override fun finish() {
        super.finish()
        Log.d("TAG", "onFinish: lifecycle first activity")
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Log.d("TAG", "onSaveInstance: lifecycle ")
    }

    override fun onRestoreInstanceState(
        savedInstanceState: Bundle?,
        persistentState: PersistableBundle?
    ) {
        super.onRestoreInstanceState(savedInstanceState, persistentState)
        Log.d("TAG", "onRestoreInstance: lifecycle ")
    }
}