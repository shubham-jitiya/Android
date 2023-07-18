package com.example.myapplication.screens.userslist.view.fragment

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.DialogLayoutAddUserBinding

class AddUserDialogFragment(private val listener: OnCreateClickListener) : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireContext(), R.style.CustomAlertDialog)
        val inflater = LayoutInflater.from(requireContext())
        val binding = DialogLayoutAddUserBinding.inflate(inflater)

        binding.buttonAdd.setOnClickListener {
            val userName = binding.textViewName.text.toString()
            val job = binding.textViewJob.text.toString()
            if (isValidInput(userName, job)) {
                listener.onClickSubmitUserInfo(userName, job)
                dialog?.dismiss()
            }
        }
        builder.setView(binding.root)

        return builder.create()
    }

    private fun isValidInput(userName: String, job: String): Boolean {
        return (userName.isNotEmpty() && job.isNotEmpty())
    }
}

interface OnCreateClickListener {
    fun onClickSubmitUserInfo(name: String, job: String)
}