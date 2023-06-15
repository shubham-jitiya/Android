package com.example.myapplication.recyclerview.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.myapplication.R

class SimpleListViewAdapter(private val context: Context, private val name: List<String>) :
    ArrayAdapter<String>(context, R.layout.item_layout_simple_list_view, name) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var view = convertView
        if (convertView == null) {
            view = LayoutInflater.from(context)
                .inflate(R.layout.item_layout_simple_list_view, parent, false)
            val viewHolder = SimpleListViewHolder()
            viewHolder.textView = view.findViewById(R.id.textViewSimpleList)
            view.tag = viewHolder
        }
        val viewHolder = view?.tag as SimpleListViewHolder
        viewHolder.textView?.text = name[position]
        return view
    }
}

class SimpleListViewHolder() {
    var textView: TextView? = null
}