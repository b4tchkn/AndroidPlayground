package com.batch.recyclerviewsample.ui.groupie

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
import com.batch.recyclerviewsample.databinding.FragmentGroupieBinding
import com.batch.recyclerviewsample.model.Music
import com.batch.recyclerviewsample.ui.common.CommonViewModel
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.OnItemClickListener
import timber.log.Timber


class GroupieFragment : Fragment() {

    private lateinit var groupieViewModel: CommonViewModel
    private val listAdapter = GroupAdapter<GroupieViewHolder>()
    private lateinit var binding: FragmentGroupieBinding
    private val myItemClickListener: OnItemClickListener = OnItemClickListener { item, view ->
        val position = item.getPosition(item)
        Toast.makeText(context, "$position 目のアイテムクリックされた", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        groupieViewModel =
            ViewModelProviders.of(this).get(CommonViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_groupie, container, false)
        binding = FragmentGroupieBinding.bind(view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        groupieViewModel.fetchMusic()
        binding.groupieRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = listAdapter
        }

        listAdapter.apply {
            setOnItemClickListener(myItemClickListener)
        }

        groupieViewModel.musicList.observe(viewLifecycleOwner, Observer {
            listAdapter.addAll(it.toListItem())
            listAdapter.update(it.toListItem())
        })
    }
    private fun List<Music>.toListItem(): List<ListItem> {
        return this.map {
            ListItem(it)
        }
    }
}