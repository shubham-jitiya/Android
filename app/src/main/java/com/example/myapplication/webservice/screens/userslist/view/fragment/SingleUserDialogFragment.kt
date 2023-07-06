package com.example.myapplication.webservice.screens.userslist.view.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.myapplication.databinding.ItemLayoutUsersListBinding
import com.example.myapplication.webservice.screens.userslist.model.dataclass.SingleUser

class SingleUserDialogFragment(private val userInfo: SingleUser) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = LayoutInflater.from(requireActivity())
        val binding = ItemLayoutUsersListBinding.inflate(inflater)
        binding.textViewFullName.text =
            String.format("%s %s", userInfo.data.first_name, userInfo.data.last_name)
        binding.textViewEmailId.text = userInfo.data.email
        binding.textViewEmployeeId.text = String.format(
            "Employee id: %s", userInfo.data.id
        )
        Glide.with(requireContext())
            .load(userInfo.data.avatar)
            .transform(CircleCrop())
            .into(binding.imageViewUserProfile)
        builder.setView(binding.root)
        builder.setTitle("User info")
        return builder.create()
    }
}