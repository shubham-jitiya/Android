package com.example.myapplication.uiwidgets

import android.os.Bundle
import android.util.Log
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivitySelectioncontrolsBinding

class SelectionControlsActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySelectioncontrolsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySelectioncontrolsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        // Checkbox
        val isFirstChecked = binding.checkboxFirst.isChecked
        val isSecondChecked = binding.checkboxSecond.isChecked
        Log.d("TAG", "onCreate: first: ${isFirstChecked} second: ${isSecondChecked}")
        binding.checkboxFirst.setOnCheckedChangeListener { firstCheckBox, isChecked ->
            Log.d(
                "TAG", "checked change [text]: ${firstCheckBox.text} | checked status: $isChecked"
            )
        }
        // Radio buttons
        val radioButtonId = binding.radioButtonGender.checkedRadioButtonId
        Log.d("TAG", "onCreate: radioButtonId: $radioButtonId")
        binding.radioButtonGender.setOnCheckedChangeListener { gender, id ->
            if (id == -1) {
                Log.d("TAG", "onCreate: Selected radio button: Not selected")
            } else {
                val selectedRadioButton = findViewById<RadioButton>(id)
                Log.d("TAG", "onCreate: Selected radio button: ${selectedRadioButton.text}")
            }
        }
    }
}