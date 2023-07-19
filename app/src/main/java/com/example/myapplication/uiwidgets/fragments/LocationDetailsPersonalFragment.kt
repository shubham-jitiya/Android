package com.example.myapplication.uiwidgets.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentLocationDetailsPersonalBinding
import java.util.*

class LocationDetailsPersonalFragment : Fragment() {
    private var _binding: FragmentLocationDetailsPersonalBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLocationDetailsPersonalBinding.inflate(layoutInflater)
        initialSetup()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun initialSetup() {
        setupStartDate()
        setupEndDate()
        setupStartTime()
        setupEndTime()
    }

    private fun setupStartDate() {
        binding.editTextEnterAfterDate.setOnClickListener {
            datePickerDialog(binding.editTextEnterAfterDate)
        }
    }

    private fun setupEndDate() {
        binding.editTextExitBeforeDate.setOnClickListener {
            datePickerDialog(binding.editTextExitBeforeDate)
        }
    }

    private fun setupStartTime() {
        binding.editTextEnterAfterTime.setOnClickListener {
            timePickerDialog(binding.editTextEnterAfterTime)
        }
    }

    private fun setupEndTime() {
        binding.editTextExitBeforeTime.setOnClickListener {
            timePickerDialog(binding.editTextExitBeforeTime)
        }
    }

    private fun datePickerDialog(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)
        context?.let { it ->
            DatePickerDialog(it, { view, year, monthOfYear, dayOfMonth ->
                val date = "$dayOfMonth/${monthOfYear + 1}/$year"
                editText.setText(date)
            }, year, month, day)
        }?.show()
    }

    private fun timePickerDialog(editText: EditText) {
        val currentTime = Calendar.getInstance()
        val hour = currentTime.get(Calendar.HOUR_OF_DAY)
        val minute = currentTime.get(Calendar.MINUTE)
        val timePickerDialog = TimePickerDialog(context, { _, selectedHour, selectedMinute ->
            val AM_PM: String = if (selectedHour > 12) "PM" else "AM"
            val formattedTime = String.format("%02d:%02d %s", selectedHour, selectedMinute, AM_PM)
            editText.setText(formattedTime)
        }, hour, minute, true)
        timePickerDialog.show()
    }

}