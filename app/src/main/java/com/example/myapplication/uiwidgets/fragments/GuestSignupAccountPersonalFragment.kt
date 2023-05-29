package com.example.myapplication.uiwidgets.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myapplication.databinding.FragmentGuestSignupAccountPersonalBinding
import com.example.myapplication.uiwidgets.GuestLocationDetailsActivity

class GuestSignupAccountPersonalFragment : Fragment() {
    private var _binding: FragmentGuestSignupAccountPersonalBinding? = null
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
        _binding = FragmentGuestSignupAccountPersonalBinding.inflate(layoutInflater)
        navigateToLocationDetailsActivity()
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun navigateToLocationDetailsActivity() {
        binding.buttonCreateAccount.setOnClickListener {
            val intent = Intent(context, GuestLocationDetailsActivity::class.java)
            startActivity(intent)
        }
    }
}