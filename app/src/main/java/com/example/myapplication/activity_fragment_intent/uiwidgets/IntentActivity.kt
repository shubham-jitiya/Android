package com.example.myapplication.activity_fragment_intent.uiwidgets

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.AlarmClock
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.FileProvider
import androidx.core.content.res.ResourcesCompat
import androidx.databinding.DataBindingUtil
import com.example.myapplication.activity_fragment_intent.Constants
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityIntentBinding
import java.io.File

class IntentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityIntentBinding
    private val contract = registerForActivityResult(ActivityResultContracts.GetContent()) {
        if (it != null) {
            binding.imageViewIntentGallery.setImageURI(it)
        } else {
            binding.imageViewIntentGallery.setImageDrawable(
                ResourcesCompat.getDrawable(
                    resources,
                    R.drawable.ic_launcher_background,
                    null
                )
            )
        }
    }
    private var imageUri: Uri? = null
    private val contractCameraImage =
        registerForActivityResult(ActivityResultContracts.TakePicture()) {
            binding.imageViewIntentCameraImage.setImageURI(null)
            binding.imageViewIntentCameraImage.setImageURI(imageUri)
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_intent)
        setupClickListeners()
    }

    private fun setupClickListeners() {
        binding.buttonIntentExplicit.setOnClickListener {
            handleExplicitIntent()
        }

        binding.buttonIntentBrowser.setOnClickListener {
            setupIntentBrowser("http://google.com")
        }

        binding.buttonIntentAlarm.setOnClickListener {
            setupIntentAlarm("Good morning", 7, 35)
        }

        binding.buttonIntentMail.setOnClickListener {
            setupIntentMail(arrayOf("jitiya66@gmail.com"), "Test mail", null)
        }

        binding.buttonIntentGallery.setOnClickListener {
            setupIntentGallery()
        }

        binding.buttonIntentCameraImage.setOnClickListener {
            imageUri = getImageUri()
            contractCameraImage.launch(imageUri)
        }
    }

    private fun handleExplicitIntent() {
        val intent = Intent(this, LifecycleActivity::class.java)
        val bundle = Bundle()
        bundle.putString("USERNAME", Constants.USERNAME)
        bundle.putInt("USER_ID", Constants.USER_ID)
        intent.putExtra("USER_INFO_BUNDLE", bundle)
        startActivity(intent)
    }

    private fun setupIntentBrowser(url: String) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Unable to find app", Toast.LENGTH_LONG).show()
        }
    }

    private fun setupIntentAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
            putExtra(AlarmClock.EXTRA_SKIP_UI, true)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "Unable to find app", Toast.LENGTH_LONG).show()
        }
    }

    private fun setupIntentMail(address: Array<String>, subject: String, attachment: Uri?) {
        val intent = Intent(Intent.ACTION_SENDTO).apply {
            data = Uri.parse("mailto:")
            putExtra(Intent.EXTRA_EMAIL, address)
            putExtra(Intent.EXTRA_SUBJECT, subject)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }

    private fun setupIntentGallery() {
        contract.launch("image/*")
    }

    private fun getImageUri(): Uri? {
        val image = File(applicationContext.filesDir, Constants.FILE_NAME_CHILD)
        return FileProvider.getUriForFile(applicationContext, Constants.AUTHORITY, image)
    }
}