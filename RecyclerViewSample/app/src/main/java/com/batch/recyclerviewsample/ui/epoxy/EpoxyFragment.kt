package com.batch.recyclerviewsample.ui.epoxy

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.batch.recyclerviewsample.R
import com.batch.recyclerviewsample.model.Music
import com.batch.recyclerviewsample.ui.groupie.GroupieViewModel
import kotlinx.android.synthetic.main.fragment_epoxy.*
import timber.log.Timber

class EpoxyFragment : Fragment(), ListController.ClickListener {

    private lateinit var viewModel: GroupieViewModel
    private val controller by lazy { ListController(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(this).get(GroupieViewModel::class.java)
        return inflater.inflate(R.layout.fragment_epoxy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchRemote()
        epoxy_recycler_view.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = controller.adapter
        }
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.musics.observe(this, Observer { musics ->
            musics?.let {
                controller.setData(musics)
            }
        })
    }

    override fun itemClickListener(item: Music) {
        val action = EpoxyFragmentDirections.actionToMusicDetail(item)
        findNavController().navigate(action)
//        Toast.makeText(context, item.toString(), Toast.LENGTH_SHORT).show()
    }
}