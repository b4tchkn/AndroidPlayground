package com.batch.exoplayermotionlayout

import android.content.Context
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.System.load

class PlayMusicFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().tool_bar.visibility = View.GONE
        (activity as AppCompatActivity).supportActionBar?.hide()
        return inflater.inflate(R.layout.fragment_play_music, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val coverImage = view.findViewById<ImageView>(R.id.cover_image_view)
        val args: PlayMusicFragmentArgs by navArgs()
        val coverPath = args.coverPath
        val musicTitle = args.musicTitle
        val description = args.description
        val musicTitleTextView = view.findViewById<TextView>(R.id.music_title_text_view)
        val artistNameTextView = view.findViewById<TextView>(R.id.artist_name_text_view)
        musicTitleTextView.text = musicTitle
        artistNameTextView.text = description
        Glide.with(this)
            .load(coverPath)
            .onlyRetrieveFromCache(true)
            .into(coverImage)
    }
}
