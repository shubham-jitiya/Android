package com.example.myapplication.recyclerview.adapters

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.selection.ItemDetailsLookup
import androidx.recyclerview.selection.SelectionTracker
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.recyclerview.models.Folder

class FoldersAdapter(val folderDetails: ArrayList<Folder>) :
    RecyclerView.Adapter<FoldersAdapter.FoldersAdapterViewHolder>() {
    private var tracker: SelectionTracker<Long>? = null

    init {
        setHasStableIds(true)
    }

    fun setTracker(tracker: SelectionTracker<Long>?) {
        this.tracker = tracker
    }

    fun getTracker() = tracker

    class FoldersAdapterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textViewFolderTitle = itemView.findViewById<TextView>(R.id.textViewFolderTitle)
        private val textViewFolderSubtitle =
            itemView.findViewById<TextView>(R.id.textViewFolderSubtitle)
        private val constraintLayout =
            itemView.findViewById<ConstraintLayout>(R.id.constraintLayoutFolders)

        fun bind(folderName: String, folderDetails: String, tracker: SelectionTracker<Long>?) {
            textViewFolderTitle.text = folderName
            textViewFolderSubtitle.text = folderDetails

            if (tracker?.isSelected(itemId) == true) {
                constraintLayout.background = ColorDrawable(Color.CYAN)
            } else {
                constraintLayout.background = ColorDrawable(Color.WHITE)
            }
        }

        // multiple selection
        fun getSelectedItemDetails(): ItemDetailsLookup.ItemDetails<Long> =
            object : ItemDetailsLookup.ItemDetails<Long>() {
                override fun getPosition(): Int = adapterPosition
                override fun getSelectionKey(): Long = itemId
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoldersAdapterViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_layout_recycler_view_folders, parent, false)
        return FoldersAdapterViewHolder(layout)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemCount(): Int {
        return folderDetails.size
    }

    override fun onBindViewHolder(holder: FoldersAdapterViewHolder, position: Int) {
        holder.bind(
            folderDetails[position].folderName,
            folderDetails[position].folderItems,
            tracker
        )
    }
}