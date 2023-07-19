package com.example.myapplication.uiwidgets

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityUiwidgetsBinding

class UIWidgetsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUiwidgetsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUiwidgetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnButton.setOnClickListener {
            val intent = Intent(this, ButtonsActivity::class.java)
            startActivity(intent)
        }

        binding.btnToast.setOnClickListener {
            val intent = Intent(this, ToastActivity::class.java)
            startActivity(intent)
        }

        binding.btnToggle.setOnClickListener {
            val intent = Intent(this, ToggleActivity::class.java)
            startActivity(intent)
        }

        binding.btnImageButton.setOnClickListener {
            val intent = Intent(this, ImageButtonActivity::class.java)
            startActivity(intent)
        }

        binding.btnCheckbox.setOnClickListener {
            val intent = Intent(this, SelectionControlsActivity::class.java)
            startActivity(intent)
        }

        binding.btnFloatingActionButton.setOnClickListener {
            val intent = Intent(this, FloatingActionButtonActivity::class.java)
            startActivity(intent)
        }

        binding.btnSnackbar.setOnClickListener {
            val intent = Intent(this, SnackbarActivity::class.java)
            startActivity(intent)
        }

        binding.btnTextInputLayout.setOnClickListener {
            val intent = Intent(this, TextInputLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnTabLayout.setOnClickListener {
            val intent = Intent(this, TabLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnAppBar.setOnClickListener {
            val intent = Intent(this, AppBarActivity::class.java)
            startActivity(intent)
        }

        binding.btnLinearLayout.setOnClickListener {
            val intent = Intent(this, LinearLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnRelativeLayout.setOnClickListener {
            val intent = Intent(this, RelativeLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnGridLayout.setOnClickListener {
            val intent = Intent(this, GridLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnFrameLayout.setOnClickListener {
            val intent = Intent(this, FrameLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnFrameLayoutFragment.setOnClickListener {
            val intent = Intent(this, FrameLayoutManagerActivity::class.java)
            startActivity(intent)
        }

        binding.btnConstraintLayout.setOnClickListener {
            val intent = Intent(this, ConstraintLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnGridLayoutProject.setOnClickListener {
            val intent = Intent(this, GridLayoutProjectActivity::class.java)
            startActivity(intent)
        }

        binding.btnCoordinateLayout.setOnClickListener {
            val intent = Intent(this, CoordinateLayoutActivity::class.java)
            startActivity(intent)
        }

        binding.btnNavigationHost.setOnClickListener {
            val intent = Intent(this, NavigationComponentActivity::class.java)
            startActivity(intent)
        }

        binding.btnGuestSignup.setOnClickListener {
            val intent = Intent(this, GuestSignupActivity::class.java)
            startActivity(intent)
        }
        binding.btnGuestLocationDetails.setOnClickListener {
            val intent = Intent(this, GuestLocationDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}