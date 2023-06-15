package com.example.myapplication.recyclerview.util

import android.content.Context
import android.graphics.Canvas
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.recyclerview.adapters.GmailAdapter


class SwipeToDeleteGmailCallback(
    private val adapter: GmailAdapter,
    private val recyclerView: RecyclerView,
    private val context: Context
) :
    ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        return false
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        val deletedItem = adapter.deleteItemAt(viewHolder.layoutPosition)
        adapter.showActionUndoSnackbar(recyclerView, deletedItem, viewHolder.layoutPosition)
    }

    override fun onChildDraw(
        c: Canvas,
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        dX: Float,
        dY: Float,
        actionState: Int,
        isCurrentlyActive: Boolean
    ) {
        if (actionState == ItemTouchHelper.ACTION_STATE_SWIPE) {
            val itemView = viewHolder.itemView
            val deleteIcon = ResourcesCompat.getDrawable(
                context.resources, R.drawable.ic_delete, null
            ) ?: return
            val iconWidth = deleteIcon.intrinsicWidth
            val iconHeight = deleteIcon.intrinsicHeight
            val itemHeight = itemView.bottom - itemView.top
            val iconTop = itemView.top + (itemHeight - iconHeight) / 2
            val iconMargin = (itemHeight - iconHeight) / 2
            val iconLeft: Int
            val iconRight: Int
            if (dX > 0) {
                iconLeft = itemView.left + iconMargin
                iconRight = itemView.left + iconMargin + iconWidth
            } else {
                iconLeft = itemView.right - iconMargin - iconWidth
                iconRight = itemView.right - iconMargin
            }
            val iconBottom = iconTop + iconHeight
            deleteIcon.setBounds(iconLeft, iconTop, iconRight, iconBottom)
            deleteIcon.draw(c)
        }
        super.onChildDraw(c, recyclerView, viewHolder, dX / 4, dY, actionState, isCurrentlyActive)
    }
}