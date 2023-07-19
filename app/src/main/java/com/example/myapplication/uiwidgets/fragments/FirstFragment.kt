package com.example.myapplication.uiwidgets.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.myapplication.databinding.FragmentFirstBinding
import com.example.myapplication.uiwidgets.models.UserFragment

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
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
        _binding = FragmentFirstBinding.inflate(layoutInflater)
        binding.btnGotoSecondFragment.setOnClickListener {
            val action =
                FirstFragmentDirections.actionFirstFragmentToSecondFragment("From First fragment")
            findNavController().navigate(action)
        }
        binding.btnGotoThirdFragment.setOnClickListener {
            val firstName = binding.textViewFirstNameFragmentFirst.text.toString()
            val lastName = binding.textViewLastNameFragmentFirst.text.toString()
            val userInfo = UserFragment(firstName, lastName)
            val action = FirstFragmentDirections.actionFirstFragmentToThirdFragment(userInfo)
            findNavController().navigate(action)
        }
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}