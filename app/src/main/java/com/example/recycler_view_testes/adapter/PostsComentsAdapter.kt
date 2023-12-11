package com.example.recycler_view_testes.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recycler_view_testes.R
import com.example.recycler_view_testes.db.PostsComents

class PostsComentsAdapter(val context: Context, val list: List<PostsComents>) :
    RecyclerView.Adapter<PostsComentsAdapter.PostsComentsViewHolder>() {

    class PostsComentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val id: TextView = itemView.findViewById(R.id.id)
        val name: TextView = itemView.findViewById(R.id.name)
        val email: TextView = itemView.findViewById(R.id.email)
        val body: TextView = itemView.findViewById(R.id.body)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsComentsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_list_coments, parent, false)
        return PostsComentsViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: PostsComentsViewHolder, position: Int) {
        val _list = list[position]

        holder.id.text = _list.id
        holder.name.text = _list.name
        holder.email.text = _list.email
        holder.body.text = _list.body
    }
}