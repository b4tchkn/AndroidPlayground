package com.batch.recyclerviewsample.ui.default

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.batch.recyclerviewsample.R
import com.batch.recyclerviewsample.ui.groupie.GroupieViewModel
import kotlinx.android.synthetic.main.fragment_default.*

class DefaultFragment : Fragment() {

    private lateinit var viewModel: GroupieViewModel
    private var defaultAdapter = DefaultAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(GroupieViewModel::class.java)
        return inflater.inflate(R.layout.fragment_default, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchRemote()
        default_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = defaultAdapter
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.musics.observe(this, Observer { musics ->
            defaultAdapter.updateList(musics)
        })
    }
}