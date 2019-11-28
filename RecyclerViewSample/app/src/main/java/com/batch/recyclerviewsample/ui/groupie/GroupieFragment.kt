package com.batch.recyclerviewsample.ui.groupie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.batch.recyclerviewsample.R
import com.batch.recyclerviewsample.databinding.FragmentGroupieBinding
import com.batch.recyclerviewsample.model.Music
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_groupie.*

class GroupieFragment : Fragment() {

    private lateinit var groupieViewModel: GroupieViewModel
    private val listAdapter = GroupAdapter<GroupieViewHolder>()
    private lateinit var binding: FragmentGroupieBinding
    private val onItemClickListener = OnItemClickListener {item, view ->
        val index = this.listAdapter.getAdapterPosition(item)
        Toast.makeText(context, index.toString(), Toast.LENGTH_SHORT).show()
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        groupieViewModel =
            ViewModelProviders.of(this).get(GroupieViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_groupie, container, false)
        binding = FragmentGroupieBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        groupieViewModel.fetchRemote()
        observeViewModel()
    }

    private fun observeViewModel() {
        groupieViewModel.musics.observe(this, Observer {
            initRecyclerView(it.toListItem())
        })
    }

    private fun initRecyclerView(listItem: List<ListItem>) {
        listAdapter.apply {
            update(listItem)
            setOnItemClickListener(onItemClickListener)
        }
        binding.groupieRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = listAdapter
        }
//        groupie_recycler_view.apply {
//        }
    }

    private fun List<Music>.toListItem(): List<ListItem> {
        return this.map {
            ListItem(it)
        }
    }
}