package com.batch.kmm_sample.androidApp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.batch.kmm_sample.shared.entity.RocketLaunch

class LaunchesRecyclerViewAdapter(var launches: List<RocketLaunch>) :
    RecyclerView.Adapter<LaunchesRecyclerViewAdapter.LaunchViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LaunchViewHolder {
        return LayoutInflater.from(parent.context)
            .inflate(R.layout.item_launch, parent, false)
            .run(::LaunchViewHolder)
    }

    override fun onBindViewHolder(holder: LaunchViewHolder, position: Int) {
        holder.bindData(launch = launches[position])
    }

    override fun getItemCount(): Int = launches.count()

    inner class LaunchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val missionNameTextView = itemView.findViewById<TextView>(R.id.mission_name)
        private val launchSuccessTextView = itemView.findViewById<TextView>(R.id.launch_success)
        private val launchYearTextView = itemView.findViewById<TextView>(R.id.launch_year)
        private val missionDetailsTextView = itemView.findViewById<TextView>(R.id.details)

        fun bindData(launch: RocketLaunch) {
            val ctx = itemView.context
            missionNameTextView.text =
                ctx.getString(R.string.mission_name_field, launch.missionName)
            launchYearTextView.text =
                ctx.getString(R.string.launch_year_field, launch.launchYear.toString())
            missionDetailsTextView.text =
                ctx.getString(R.string.details_field, launch.details ?: "")
            val launchSuccess = launch.launchSuccess
            if (launchSuccess != null) {
                if (launchSuccess) {
                    launchSuccessTextView.text = ctx.getString(R.string.successful)
                    launchSuccessTextView.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.colorSuccessful
                        )
                    )
                } else {
                    launchSuccessTextView.text = ctx.getString(R.string.unsuccessful)
                    launchSuccessTextView.setTextColor(
                        ContextCompat.getColor(
                            itemView.context,
                            R.color.colorUnsuccessful
                        )
                    )
                }
            } else {
                launchSuccessTextView.text = ctx.getString(R.string.no_data)
                launchSuccessTextView.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.colorNoData
                    )
                )
            }
        }
    }
}