package com.batch.exoplayermotionlayout.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.batch.exoplayermotionlayout.R
import com.batch.exoplayermotionlayout.model.Music
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.OnItemClickListener
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import timber.log.Timber

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private val musicListAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        homeViewModel.fetchRemote()
        Timber.d("koko")
        observeViewModel()
        requireActivity().tool_bar.visibility = View.VISIBLE
        val itemDecoration = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        musicListRecyclerView.addItemDecoration(itemDecoration)
    }

    private fun observeViewModel() {
        homeViewModel.musics.observe(this, Observer {
            initRecyclerView(it.toMusicListItem())
        })
    }

    private fun initRecyclerView(musicListItem: List<MusicListItem>) {
        musicListAdapter.apply {
            update(musicListItem)
            setOnItemClickListener(onItemClickListener)
        }
        musicListRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = musicListAdapter
        }
    }

    fun List<Music>.toMusicListItem(): List<MusicListItem> {
        return this.map {
            MusicListItem(it)
        }
    }

    private val onItemClickListener = OnItemClickListener {item, view ->
        val index = this.musicListAdapter.getAdapterPosition(item)
        val coverImage = view.findViewById<ImageView>(R.id.coverImageView)
        val coverPath = homeViewModel.musics.value!![index].coverPath
        Glide.with(this)
            .load(coverPath)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(coverImage)
        val action = HomeFragmentDirections.actionPlayMusicFragment()
        action.musicTitle = homeViewModel.musics.value!![index].name
        action.description = homeViewModel.musics.value!![index].description
        action.coverPath = coverPath
        Navigation.findNavController(activity!!, R.id.nav_host_fragment).navigate(action)
    }
}