package com.batch.coroutine_sample

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.batch.coroutine_sample.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.lifecycleScope.launchWhenStarted {
            viewModel.count.collect {
                binding.textView.text = it.toString()
                Log.d("yahoooo", it.toString())
            }
        }

        this.lifecycleScope.launch {
            viewModel.count10Event.collect {
                Log.d("count10Event", it.toString())
            }
        }

        binding.floatingActionButton.setOnClickListener {
            viewModel.incrementCounter()
        }
    }
}