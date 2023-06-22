package com.example.myapplication.activity_fragment_intent

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import com.example.myapplication.activity_fragment_intent.fragments.DataPassListener
import com.example.myapplication.activity_fragment_intent.fragments.HomeScreenFragment
import com.example.myapplication.activity_fragment_intent.uiwidgets.FirstActivity
import com.example.myapplication.activity_fragment_intent.uiwidgets.IntentActivity
import com.example.myapplication.activity_fragment_intent.uiwidgets.WebViewActivity
import com.example.myapplication.databinding.ActivityFragmentDemoCommunicationBinding

class FragmentDemoCommunicationActivity : AppCompatActivity(), DataPassListener {
    private lateinit var binding: ActivityFragmentDemoCommunicationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFragmentDemoCommunicationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonActivityLifecycle.setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivity(intent)
        }

        binding.buttonIntent.setOnClickListener {
            val intent = Intent(this, IntentActivity::class.java)
            startActivity(intent)
        }

        binding.buttonFragmentCommunication.setOnClickListener {
            replaceFragment(HomeScreenFragment())
        }

        createNotificationChannel()
        binding.buttonPendingIntent.setOnClickListener {
            sendNotification()
        }

        binding.buttonWebView.setOnClickListener {
            val intent = Intent(this, WebViewActivity::class.java)
            startActivity(intent)
        }
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel name"
            val descriptionText = "Channel description"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(Constants.CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }
            val notificationManager =
                getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(channel)
        }
    }

    private fun sendNotification() {
        val intent = Intent(this, IntentActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(
            this, Constants.REQUEST_CODE, intent, PendingIntent.FLAG_IMMUTABLE
        )
        val builder = NotificationCompat.Builder(this, Constants.CHANNEL_ID)
            .setSmallIcon(android.R.drawable.checkbox_on_background).setContentTitle("Title")
            .setContentText("Content description").setStyle(
                NotificationCompat.BigTextStyle()
                    .bigText("Good morning, Wishing you good luck for your day")
            ).setPriority(NotificationCompat.PRIORITY_DEFAULT).setContentIntent(pendingIntent)
            .setAutoCancel(true)

        with(NotificationManagerCompat.from(this)) {
            if (ActivityCompat.checkSelfPermission(
                    this@FragmentDemoCommunicationActivity, Manifest.permission.POST_NOTIFICATIONS
                ) != PackageManager.PERMISSION_GRANTED
            ) {
                // handle permission
                return
            }
            notify(Constants.NOTIFICATION_ID, builder.build())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction().addToBackStack(null)
        fragmentTransaction.replace(R.id.fragmentContainerMainActivity, fragment)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        supportFragmentManager.popBackStack()
    }

    override fun passData(message: String) {
        binding.buttonFragmentCommunication.text = message
        Log.d("TAG", "passData: $message")
    }
}