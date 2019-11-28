package com.batch.recyclerviewsample.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.batch.recyclerviewsample.R

class DefaultFragment : Fragment() {

    private lateinit var defaultViewModel: DefaultViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        defaultViewModel =
            ViewModelProviders.of(this).get(DefaultViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_default, container, false)
////        val textView: TextView = root.findViewById(R.id.text_home)
//        defaultViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return root
    }
}