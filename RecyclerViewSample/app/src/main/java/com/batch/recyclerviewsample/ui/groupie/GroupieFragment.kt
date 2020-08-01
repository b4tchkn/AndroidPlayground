package com.batch.recyclerviewsample.ui.groupie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.batch.recyclerviewsample.R
import com.batch.recyclerviewsample.databinding.FragmentGroupieBinding
import com.batch.recyclerviewsample.model.Music
import com.batch.recyclerviewsample.ui.common.CommonViewModel
import com.xwray.groupie.Group
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.OnItemClickListener
import com.xwray.groupie.groupiex.plusAssign
import timber.log.Timber


class GroupieFragment : Fragment() {

    private lateinit var viewModel: CommonViewModel
    private val adapter = GroupAdapter<GroupieViewHolder>()
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
        viewModel =
            ViewModelProviders.of(this).get(CommonViewModel::class.java)
        val view = inflater.inflate(R.layout.fragment_groupie, container, false)
        binding = FragmentGroupieBinding.bind(view)
        return view
    }

    @ExperimentalStdlibApi
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.fetchMusic()
        binding.groupieRecyclerView.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
            adapter = adapter
        }

        adapter.apply {
            setOnItemClickListener(myItemClickListener)
        }

        // carousel追加
//        adapter.add(makeCarouselItem())

        viewModel.musicList.observe(viewLifecycleOwner, Observer { list->
//            adapter.addAll(it.toListItem())
//            adapter.update(it.toListItem())

            val groupList = mutableListOf<Group>()
            adapter += groupList

            list.forEach {
                groupList.add(ListItem(it))
            }

            adapter.update(groupList)

        })
    }

//    private fun List<Music>.toListItem(): List<ListItem> {
//        return this.map {
//            ListItem(it)
//        }
//    }

    @ExperimentalStdlibApi
    private fun makeCarouselItem(): CarouselListItem {
        val carouselAdapter = GroupAdapter<GroupieViewHolder>()
        carouselAdapter.apply {
//            setOnItemClickListener()
        }

        viewModel.musicList.observe(viewLifecycleOwner, Observer { musicList ->
            val itemList = buildList<Group> {
                musicList.forEach { music ->
                    this.add(ListItem(music))
                }
            }
            carouselAdapter.update(itemList)
        })

        return CarouselListItem(carouselAdapter)
    }
}