package com.example.myapplication.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemLayoutRecentContactsBinding
import com.example.myapplication.recyclerview.models.Contact
import com.example.myapplication.recyclerview.models.DataSource

class ContactsAdapter(private var list: MutableList<Contact>) :
    RecyclerView.Adapter<ContactsAdapter.ContactsViewHolder>() {
    private var previousSelectedPosition = -1

    inner class ContactsViewHolder(private val binding: ItemLayoutRecentContactsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(contact: Contact) {
            binding.apply {
                imageViewContacts.setImageResource(contact.image)
                textViewContactsName.text = contact.name
                textViewContactsEmail.text = contact.email
                handleBioVisibility(contact)
                buttonBio.setOnClickListener {
                    handleSingleSelection(adapterPosition)
                }
            }
        }

        private fun toggleBioVisibility(isSelected: Boolean) =
            if (isSelected) View.GONE else View.VISIBLE

        private fun handleBioVisibility(contact: Contact) {
            binding.apply {
                dividerAboveBio.visibility = toggleBioVisibility(!contact.isSelected)
                textViewMailBioTitle.visibility = toggleBioVisibility(!contact.isSelected)
                textViewContactsBioDetails.visibility = toggleBioVisibility(!contact.isSelected)
                textViewContactsBioDetails.text = contact.bio
            }
        }
    }

    private fun handleSingleSelection(currentPosition: Int) {
        if (previousSelectedPosition != -1) {
            if (previousSelectedPosition == currentPosition) {
                list[currentPosition].isSelected = !list[currentPosition].isSelected
                previousSelectedPosition = -1
                notifyItemChanged(currentPosition)
            } else {
                list[previousSelectedPosition].isSelected =
                    !list[previousSelectedPosition].isSelected
                notifyItemChanged(previousSelectedPosition)
                list[currentPosition].isSelected = !list[currentPosition].isSelected
                previousSelectedPosition = currentPosition
                notifyItemChanged(currentPosition)
            }
        } else {
            list[currentPosition].isSelected = !list[currentPosition].isSelected
            previousSelectedPosition = currentPosition
            notifyItemChanged(currentPosition)
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ContactsViewHolder {
        val layout = ItemLayoutRecentContactsBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return ContactsViewHolder(layout)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ContactsViewHolder, position: Int) {
        holder.bind(list[position])
    }

    fun filter(query: String?) {
        if(query.isNullOrEmpty()) {
            list = DataSource().getMailContacts()
            notifyDataSetChanged()
            return
        }
        val filteredData =
            DataSource().getMailContacts().filter { it.name.contains(query, true) }
        list = filteredData as MutableList<Contact>
        notifyDataSetChanged()
    }
}