package com.example.recycler_view_testes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view_testes.R
import com.example.recycler_view_testes.db.Posts

class PostsAdapter(private val context: Context, private var list: List<Posts>) :
    RecyclerView.Adapter<PostsAdapter.UserViewHolder>() {

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val body: TextView = itemView.findViewById(R.id.body)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list, parent, false)
        return UserViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val list_ = list[position]


        holder.title.text = list_.title
        holder.body.text = list_.body
    }

}