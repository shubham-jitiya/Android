package com.example.myapplication.activity_fragment_intent.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.fragment.app.viewModels
import com.example.myapplication.databinding.FragmentBooksBinding
import com.example.myapplication.activity_fragment_intent.models.SharedViewModel

class BooksFragment : Fragment() {
    private lateinit var binding: FragmentBooksBinding
    var dataPassBookListener: DataPassBook? = null
    private val sharedViewModel: SharedViewModel by viewModels({ requireParentFragment() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentBooksBinding.inflate(layoutInflater, container, false)

        sharedViewModel.message.observe(viewLifecycleOwner) { message ->
            binding.textViewBooksFragmentData.text = String.format("Data: %s", message)
        }

        binding.buttonSendToChatFragment.setOnClickListener {
            sharedViewModel.saveMessage(binding.editTextBookFragment.text.toString())
            communicateByFragmentManager()
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (parentFragment is DataPassBook) {
            dataPassBookListener = parentFragment as DataPassBook
            childFragmentManager
        }
    }

    private fun communicateByFragmentManager() {
        val result = binding.editTextBookFragment.text.toString()
        setFragmentResult("requestKeyChat", bundleOf("bundleKeyChat" to result))
    }
}

interface DataPassBook {
    fun bookName(name: String)
}
