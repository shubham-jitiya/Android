package com.example.myapplication.uiwidgets

import android.app.Activity
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityToastBinding

class ToastActivity : AppCompatActivity() {
    private lateinit var binding: ActivityToastBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityToastBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnToastDefault.setOnClickListener {
            Toast.makeText(this, "Default toast", Toast.LENGTH_SHORT).show()
        }
        binding.btnToastLeft.setOnClickListener {
            val toast = Toast.makeText(this, "Left Toast", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.START, 0, 0)
            toast.show()
        }
        binding.btnCustomToast.setOnClickListener {
            // show custom toast
            val toast = Toast(this)
            Toast(this).showCustomToast("Custom toast", this)
        }
    }
}

fun Toast.showCustomToast(message: String, activity: Activity) {
    val layout = activity.layoutInflater.inflate(
        R.layout.custom_toast,
        activity.findViewById(R.id.customToastContainer)
    )
    val txtView = layout.findViewById<TextView>(R.id.customToastMessage)
    txtView.text = message
    // use the application extension function
    this.apply {
        setGravity(Gravity.BOTTOM, 0, 40)
        duration = Toast.LENGTH_LONG
        view = layout
        show()
    }
}