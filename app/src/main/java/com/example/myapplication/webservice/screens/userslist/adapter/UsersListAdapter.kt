package com.example.myapplication.webservice.screens.userslist.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.myapplication.databinding.ItemLayoutUsersListBinding
import com.example.myapplication.webservice.screens.login.model.dataclass.User

class UsersListAdapter(
    private val listener: OnItemClickListener,
    private var list: List<User>
) :
    RecyclerView.Adapter<UsersListAdapter.UsersListViewHolder>() {
    inner class UsersListViewHolder(
        private val binding: ItemLayoutUsersListBinding,
        private val context: Context
    ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: User) {
            binding.textViewFullName.text = String.format("%s %s", item.first_name, item.last_name)
            binding.textViewEmailId.text = item.email
            binding.textViewEmployeeId.text = String.format("Employee id: %s", item.id)
            Glide.with(context)
                .load(item.avatar)
                .transform(CircleCrop())
                .into(binding.imageViewUserProfile)
        }
    }

    interface OnItemClickListener {
        fun onItemClick(userId: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemLayoutUsersListBinding.inflate(inflater, parent, false)
        return UsersListViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: UsersListViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.setOnClickListener {
            listener.onItemClick(list[position].id)
        }
    }

    override fun getItemCount() = list.size
    fun submitList(users: List<User>) {
        list = users
    }
}
