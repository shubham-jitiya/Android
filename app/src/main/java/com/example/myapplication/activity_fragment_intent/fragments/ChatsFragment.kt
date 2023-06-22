package com.example.myapplication.activity_fragment_intent.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentChatsBinding
import com.example.myapplication.activity_fragment_intent.models.SharedViewModel

class ChatsFragment : Fragment() {
    private lateinit var binding: FragmentChatsBinding
    private val sharedViewModel: SharedViewModel by viewModels({ requireParentFragment() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = FragmentChatsBinding.inflate(layoutInflater, container, false)
        communicateBySharedViewModel()
        arguments?.let {
            Log.d("TAG", "onCreate: ${it.getString("Name")}")
            binding.textViewChatsFragmentDataInterface.text = "${it.getString("Name")}"
        }
        communicateByFragmentManager()
        return binding.root
    }

    private fun communicateBySharedViewModel() {
        sharedViewModel.message.observe(viewLifecycleOwner) {
            binding.textViewChatsFragmentDataSharedModel.text = String.format("Data: %s", it)
        }
        binding.buttonSendToBookFragment.setOnClickListener {
            sharedViewModel.saveMessage(binding.editTextChatFragment.text.toString())
        }
    }

    @SuppressLint("SetTextI18n")
    private fun communicateByFragmentManager() {
        setFragmentResultListener("requestKeyChat") { _, bundle ->
            val result = bundle.getString("bundleKeyChat")
            binding.textViewChatsFragmentDataInterface.text =
                String.format("Data interface: %s", result)
        }
    }
}