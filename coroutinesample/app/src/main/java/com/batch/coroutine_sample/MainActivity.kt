package com.batch.coroutine_sample

import android.os.Bundle
import android.util.Log
import android.util.TypedValue
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.batch.coroutine_sample.databinding.ActivityMainBinding
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.lifecycleScope.launchWhenStarted {
            viewModel.count.collect {
                binding.textView.text = it.toString()
                Log.d("countStateFlow", it.toString())
            }
        }
        this.lifecycleScope.launch {
            viewModel.testFlow()
                .collect { Log.d("testFlow", it.toString()) }

            viewModel.count10Event.collect {
                if (it) {
                    binding.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 40F)
                    binding.textView.setTextColor(
                        resources.getColor(
                            R.color.purple_200,
                            resources.newTheme()
                        )
                    )
                } else {
                    binding.textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14F)
                    binding.textView.setTextColor(
                        resources.getColor(
                            R.color.black,
                            resources.newTheme()
                        )
                    )
                }
                Log.d("count10Event", it.toString())
            }
        }

        binding.floatingActionButton.setOnClickListener {
            viewModel.incrementCounter()
        }
    }
}