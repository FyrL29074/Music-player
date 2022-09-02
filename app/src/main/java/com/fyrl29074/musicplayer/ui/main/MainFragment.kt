package com.fyrl29074.musicplayer.ui.main

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fyrl29074.musicplayer.service.MusicPlayerService
import com.fyrl29074.musicplayer.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    // Comment/uncomment code of MediaPlayer to see the difference with/without Service
//    private var player: MediaPlayer? = null

    companion object {
        fun newInstance() = MainFragment()
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
    }

    private fun setListeners() {

        // with Service
        binding.start.setOnClickListener {
            context?.startService(Intent(context, MusicPlayerService::class.java))
        }

        binding.stop.setOnClickListener {
            context?.stopService(Intent(context, MusicPlayerService::class.java))
        }

        // without Service

//        binding.start.setOnClickListener {
//            if (player == null) {
//                player = MediaPlayer.create(activity, Settings.System.DEFAULT_RINGTONE_URI)
//                player!!.isLooping = true
//                player!!.start()
//            } else {
//                player!!.start()
//            }
//        }
//
//        binding.stop.setOnClickListener {
//            if (player != null) {
//                player!!.pause()
//            }
//        }
    }
}