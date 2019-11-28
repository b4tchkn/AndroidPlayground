package com.batch.recyclerviewsample.ui.default

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.batch.recyclerviewsample.R
import com.batch.recyclerviewsample.databinding.ItemBinding
import com.batch.recyclerviewsample.model.Music

class DefaultAdapter(private val musics: ArrayList<Music>) : RecyclerView.Adapter<DefaultAdapter.DefaultViewHolder>() {
    class DefaultViewHolder(var view: ItemBinding) : RecyclerView.ViewHolder(view.root)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DefaultViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = DataBindingUtil.inflate<ItemBinding>(inflater, R.layout.item, parent, false)
        return DefaultViewHolder(view)
    }

    override fun onBindViewHolder(holder: DefaultViewHolder, position: Int) {
        holder.view.music = musics[position]
        holder.view.musicItem.setOnClickListener {
            Toast.makeText(it.context, position.toString(), Toast.LENGTH_SHORT)
        }
    }

    override fun getItemCount(): Int = musics.size

    fun updateList(newList: List<Music>) {
        musics.clear()
        musics.addAll(newList)
        notifyDataSetChanged()
    }
}