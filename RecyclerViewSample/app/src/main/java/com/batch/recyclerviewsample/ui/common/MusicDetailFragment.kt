package com.batch.recyclerviewsample.ui.common

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs

import com.batch.recyclerviewsample.R
import com.batch.recyclerviewsample.model.Music
import kotlinx.android.synthetic.main.fragment_music_detail.*

class MusicDetailFragment : Fragment() {

    private val args: MusicDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_music_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        music_info_text.text = args.music.toString()
    }

}
