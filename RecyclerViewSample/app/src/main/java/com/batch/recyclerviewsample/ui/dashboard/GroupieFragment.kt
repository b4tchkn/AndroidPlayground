package com.batch.recyclerviewsample.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.batch.recyclerviewsample.R

class GroupieFragment : Fragment() {

    private lateinit var groupieViewModel: GroupieViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        groupieViewModel =
            ViewModelProviders.of(this).get(GroupieViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_groupie, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        groupieViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}