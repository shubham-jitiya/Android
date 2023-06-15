package com.example.myapplication.recyclerview.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemLayoutGmailChildBinding
import com.example.myapplication.databinding.ItemLayoutGmailParentBinding
import com.example.myapplication.recyclerview.models.*
import com.google.android.material.snackbar.Snackbar

class GmailAdapter(private var list: MutableList<MailParent>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private var previousSelectedIndex = -1

    inner class GmailParentViewHolder(private val binding: ItemLayoutGmailParentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(mail: Mail) {
            binding.apply {
                imageViewUserProfile.setImageResource(mail.senderImage)
                imageViewAttachment.visibility =
                    if (mail.attachment) View.VISIBLE else View.INVISIBLE
                buttonImportant.isSelected = mail.attachment
                textViewSenderName.text = mail.senderName
                textViewSubject.text = mail.subject
                textViewMessage.text = mail.email
                textViewTimeStamp.text = mail.timeStamp
            }
        }

        init {
            binding.apply {
                itemLayoutGmail.setOnClickListener {
                    setSingleSelection(adapterPosition)
                    // uncomment below line to test multi-selection
                    // setMultiSelection(adapterPosition)
                }
                buttonImportant.setOnClickListener {
                    buttonImportant.isSelected = !buttonImportant.isSelected
                }
            }
        }
    }

    inner class GmailChildViewHolder(private val binding: ItemLayoutGmailChildBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(sublist: MutableList<MailChild>) {
            binding.apply {
                val data = sublist.first()
                textViewPreviousMailSubject.text = data.previousMail
                textViewPreviousMailTimeStamp.text = data.timeStamp
            }
        }
    }

    private fun setSingleSelection(currentPosition: Int) {
        if (previousSelectedIndex != -1) {
            if (currentPosition == previousSelectedIndex) {
                collapseParentRow(currentPosition)
                previousSelectedIndex = -1
            } else {
                collapseParentRow(previousSelectedIndex)
                if (currentPosition > previousSelectedIndex) {
                    val expandPosition = currentPosition - list[previousSelectedIndex].sublist.size
                    expandParentRow(expandPosition)
                } else {
                    expandParentRow(currentPosition)
                }
            }
            notifyDataSetChanged()
        } else {
            expandParentRow(currentPosition)
            notifyItemChanged(currentPosition)
        }
    }

    private fun setMultiSelection(currentPosition: Int) {
        expandOrCollapseParentItem(currentPosition)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == Constants.PARENT) {
            val layout = ItemLayoutGmailParentBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            GmailParentViewHolder(layout)
        } else {
            val layout = ItemLayoutGmailChildBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
            GmailChildViewHolder(layout)
        }
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is GmailParentViewHolder) {
            holder.bind(list[position].mail ?: return)
        } else if (holder is GmailChildViewHolder) {
            holder.bind(list[position].sublist)
        }
    }

    override fun getItemViewType(position: Int): Int = list[position].type

    override fun getItemId(position: Int): Long = position.toLong()

    private fun expandOrCollapseParentItem(position: Int) {
        val currentItem = list[position]
        if (currentItem.isExpanded) collapseParentRow(position) else expandParentRow(position)
    }

    private fun expandParentRow(position: Int) {
        previousSelectedIndex = position
        val currentMail = list[position]
        val previousMails = list[position].sublist
        currentMail.isExpanded = true
        var nextPosition = position
        if (currentMail.type == Constants.PARENT) {
            previousMails.forEach { mail ->
                val parentMail = MailParent()
                parentMail.type = Constants.CHILD
                parentMail.sublist = mutableListOf(mail)
                list.add(++nextPosition, parentMail)
            }
            notifyDataSetChanged()
        }
    }

    private fun collapseParentRow(position: Int) {
        val currentMail = list[position]
        val previousMails = currentMail.sublist
        currentMail.isExpanded = false
        if (currentMail.type == Constants.PARENT) {
            previousMails.forEach { _ ->
                list.removeAt(position + 1)
            }
            notifyDataSetChanged()
        }
    }

    fun deleteItemAt(position: Int): MailParent {
        val removedItem = list.removeAt(position)
        notifyItemRemoved(position)
        return removedItem
    }

    fun showActionUndoSnackbar(view: RecyclerView, item: MailParent, position: Int) {
        val snackbar = Snackbar.make(view, "Deleted", Snackbar.LENGTH_SHORT)
        snackbar.setAction("Undo") {
            list.add(position, item)
            notifyItemInserted(position)
            Toast.makeText(view.context, "Item recovered successfully", Toast.LENGTH_SHORT).show()
        }.show()
    }

    fun filterData(query: String?) {
//        val filteredList = list.filter {
//            it.mail?.senderName?.startsWith(query?: return, true) ?: return
//        }
        val filteredList = DataSource().getExpandableMails().filter {
            it.mail?.senderName?.contains(query ?: "", true) == true
        }
        list = filteredList as MutableList<MailParent>
        notifyDataSetChanged()
    }
}