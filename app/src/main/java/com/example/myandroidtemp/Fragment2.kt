package com.example.myandroidtemp

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.os.RecoverySystem
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.*
import java.util.*

class Fragment2: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val date = SimpleDateFormat("yyyy/MM/dd").format(Date())
        val itemList = mutableListOf<Item>()
        repeat((0..100).count()) { itemList.add(Item("テスト", date)) }

        view.findViewById<RecyclerView>(R.id.itemRecyclerView).also { recyclerView: RecyclerView ->
            recyclerView.adapter = ItemViewAdapter(context!!, itemList)
            recyclerView.layoutManager = LinearLayoutManager(context)
        }
    }

}