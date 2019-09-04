package com.example.myandroidtemp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemViewAdapter(private val context: Context, private val itemList: List<Item>) :
    RecyclerView.Adapter<ItemViewAdapter.ItemViewHolder>() {
    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userIconImageView: ImageView = view.findViewById(R.id.userIcon)
        val userNameTextView: TextView = view.findViewById(R.id.userName)
        val dateTextView: TextView = view.findViewById(R.id.date)
        val contentTextView: TextView = view.findViewById(R.id.content)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item, parent, false))

    override fun getItemCount(): Int = itemList.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.userIconImageView.setImageResource(R.mipmap.ic_launcher)
        holder.userNameTextView.text = "テストユーザ"
        holder.dateTextView.text = itemList[position].date
        holder.contentTextView.text = itemList[position].content
    }
}