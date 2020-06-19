package com.batch.recyclerviewsample.ui.default

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.batch.recyclerviewsample.R
import com.batch.recyclerviewsample.model.Music
import com.batch.recyclerviewsample.ui.common.CommonViewModel
import kotlinx.android.synthetic.main.fragment_default.*

class DefaultFragment : Fragment() {

    private lateinit var viewModel: CommonViewModel
    private var defaultAdapter = DefaultAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel =
            ViewModelProviders.of(this).get(CommonViewModel::class.java)
        return inflater.inflate(R.layout.fragment_default, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchMusic()
        default_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = defaultAdapter
        }
        defaultAdapter.setOnItemClickListener(object : DefaultAdapter.OnItemClickListener {
            override fun itemClick(view: View, data: Music) {
                Toast.makeText(context, data.toString(), Toast.LENGTH_SHORT).show()
            }
        })
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.musicList.observe(this, Observer { musics ->
            defaultAdapter.updateList(musics)
        })
    }
}