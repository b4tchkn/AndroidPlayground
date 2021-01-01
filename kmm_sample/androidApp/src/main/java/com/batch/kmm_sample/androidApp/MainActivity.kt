package com.batch.kmm_sample.androidApp

import android.os.Bundle
import android.util.Log
import android.widget.FrameLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.batch.kmm_sample.shared.SpaceXSDK
import com.batch.kmm_sample.shared.cache.DatabaseDriverFactory
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mainScope = MainScope()
    private val sdk = SpaceXSDK(DatabaseDriverFactory(this))

    lateinit var launchesRecyclerView: RecyclerView
    lateinit var progressBarView: FrameLayout
    lateinit var swipeRefreshLayout: SwipeRefreshLayout

    private val launchesRecyclerViewAdapter = LaunchesRecyclerViewAdapter(listOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        title = "SapaceX Launches"
        setContentView(R.layout.activity_main)

        launchesRecyclerView = findViewById(R.id.launches_recycler_view)
        progressBarView = findViewById(R.id.progress_bar)
        swipeRefreshLayout = findViewById(R.id.swipe_container)

        launchesRecyclerView.adapter = launchesRecyclerViewAdapter
        launchesRecyclerView.layoutManager = LinearLayoutManager(this)

        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            displayLaunches(true)
        }

        displayLaunches(false)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainScope.cancel()
    }

    private fun displayLaunches(needReload: Boolean) {
        progressBarView.isVisible = true
        mainScope.launch {
            kotlin.runCatching {
                sdk.getLaunches(needReload)
            }.onSuccess {
                launchesRecyclerViewAdapter.launches = it
                launchesRecyclerViewAdapter.notifyDataSetChanged()
            }.onFailure {
                Toast.makeText(this@MainActivity, it.localizedMessage, Toast.LENGTH_SHORT).show()
            }
        }
        progressBarView.isVisible = false
    }
}
