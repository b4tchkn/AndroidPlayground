package com.batch.recyclerviewsample.ui.notifications

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.batch.recyclerviewsample.R

class EpoxyFragment : Fragment() {

    private lateinit var epoxyViewModel: EpoxyViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        epoxyViewModel =
            ViewModelProviders.of(this).get(EpoxyViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_epoxy, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        epoxyViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}