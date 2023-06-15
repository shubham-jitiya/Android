package com.example.myapplication.recyclerview.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.recyclerview.adapters.ContactsAdapter
import com.example.myapplication.databinding.ContactBottomSheetBinding
import com.example.myapplication.recyclerview.models.DataSource
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class ContactBottomSheet : BottomSheetDialogFragment() {
    private var _binding: ContactBottomSheetBinding? = null
    private val binding get() = _binding
    private lateinit var adapterContacts: ContactsAdapter
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = ContactBottomSheetBinding.inflate(inflater, container, false)
        val contacts = DataSource().getMailContacts()
        adapterContacts = ContactsAdapter(contacts)
        binding?.recyclerViewContacts?.apply {
            adapter = adapterContacts
        }
        return binding?.root
    }
}