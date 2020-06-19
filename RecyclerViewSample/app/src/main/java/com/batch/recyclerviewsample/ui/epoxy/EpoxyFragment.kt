package com.batch.recyclerviewsample.ui.epoxy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.batch.recyclerviewsample.R
import com.batch.recyclerviewsample.model.Music
import com.batch.recyclerviewsample.ui.common.CommonViewModel
import kotlinx.android.synthetic.main.fragment_epoxy.*

class EpoxyFragment : Fragment(), ListController.ClickListener {

    private lateinit var viewModel: CommonViewModel
    private val controller by lazy { ListController(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(CommonViewModel::class.java)
        return inflater.inflate(R.layout.fragment_epoxy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchMusic()
        epoxy_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = controller.adapter
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.musicList.observe(this, Observer { musics ->
            musics?.let {
                controller.setData(musics)
            }
        })
    }

    override fun itemClickListener(item: Music) {
        val action = EpoxyFragmentDirections.actionToMusicDetailFromEpoxy(item)
        findNavController().navigate(action)
    }
}