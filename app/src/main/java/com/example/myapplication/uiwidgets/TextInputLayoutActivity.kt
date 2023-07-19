package com.example.myapplication.uiwidgets

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityTextInputLayoutBinding

class TextInputLayoutActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTextInputLayoutBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTextInputLayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.textInputEditTextContact.doOnTextChanged { text, start, before, count ->
            val contactLength = text?.length ?: 0
            if (contactLength > 10) {
                binding.textInputLayoutContact.error = "Can not be more than 10"
            } else {
                binding.textInputLayoutContact.error = null
            }
        }
    }

    override fun onResume() {
        super.onResume()
        setupDropDownCountries()
    }

    private fun setupDropDownCountries() {
        val countries = resources.getStringArray(R.array.country)
        val arrayAdapter = ArrayAdapter(this, R.layout.dropdown_item_countries, countries)
        binding.autoCompleteTextViewCountry.setAdapter(arrayAdapter)
    }
}