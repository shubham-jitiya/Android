package com.example.myapplication.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentWebserviceBinding

class WebserviceFragment : Fragment() {
   private lateinit var binding: FragmentWebserviceBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_webservice, container, false)
        binding.buttonPractice.setOnClickListener { findNavController().navigate(R.id.action_webserviceFragment_to_practiceFragment) }
        binding.buttonWebserviceExercise.setOnClickListener { findNavController().navigate(R.id.action_webserviceFragment_to_loginFragment) }
        return binding.root
    }
}