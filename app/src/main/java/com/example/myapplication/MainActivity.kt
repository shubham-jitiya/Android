package com.example.myapplication

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    // contract permission
    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // Permission is granted, continue the action or workflow
                Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show()
            } else if (shouldShowRequestPermissionRationale(android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
                // didn't checked: Don't ask again while denying permission
                Toast.makeText(
                    this,
                    "Needs permission to access storage!",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                //checked: Don't ask again while denying permission - open settings
                val settingsIntent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                settingsIntent.data = Uri.fromParts("package", packageName, null)
                startActivity(settingsIntent)
                Toast.makeText(
                    this,
                    "Open settings to change permanently disabled",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonSinglePermission.setOnClickListener {
            grantPermission()
        }
    }

    private fun grantPermission() {
        // don't need permission for android 28+
        if (Build.VERSION.SDK_INT > Build.VERSION_CODES.Q) {
            Toast.makeText(this, "No permission required", Toast.LENGTH_SHORT).show()
            return
        }
        // api greater than 26
        if (ContextCompat.checkSelfPermission(
                this,
                android.Manifest.permission.READ_EXTERNAL_STORAGE
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            Toast.makeText(this, "Permission already granted", Toast.LENGTH_SHORT).show()
        } else {
            // request permission
            Toast.makeText(this, "Requesting permission...", Toast.LENGTH_SHORT).show()
            requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
        }
    }
}