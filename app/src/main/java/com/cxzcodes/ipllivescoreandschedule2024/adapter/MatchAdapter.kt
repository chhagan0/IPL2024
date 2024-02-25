package com.cxzcodes.ipllivescoreandschedule2024.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.cxzcodes.TeamDetails
import com.cxzcodes.ipllivescoreandschedule2024.Ads.FBADs.FbNativeADs
import com.cxzcodes.ipllivescoreandschedule2024.R
import com.cxzcodes.ipllivescoreandschedule2024.model.MatchModel
import com.cxzcodes.ipllivescoreandschedule2024.model.ScheduleModel
import com.cxzcodes.ipllivescoreandschedule2024.model.TeamModel
import com.cxzcodes.ipllivescoreandschedule2024.model.WinnerModel
import com.facebook.ads.NativeAdLayout

class MatchAdapter(private val items: List<MatchModel>, val context: Context, val ads: Boolean) :
    RecyclerView.Adapter<MatchAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_match, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        if (ads == true) {
            if ((position + 1) % 5 == 0) {
                holder.container.visibility = View.VISIBLE
                FbNativeADs.loadNativeAd(context, holder.container)
            } else {
                holder.container.visibility = View.GONE

            }

        }
        holder.location.text = item.location
        holder.match.text = item.matchnumber
        holder.date.text = item.date
        holder.time.text = item.time
        Glide.with(context).load(item.teamone)
            .into(holder.teamone);
        Glide.with(context).load(item.teamtwo)
            .into(holder.teamtwo);

        holder.itemView.setOnClickListener {
            // Handle item click
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val teamone: ImageView = itemView.findViewById(R.id.ivteamone)
        val teamtwo: ImageView = itemView.findViewById(R.id.ivteamtwo)
        val location: TextView = itemView.findViewById(R.id.tvlocationM)
        val match: TextView = itemView.findViewById(R.id.tvmatchno)
        val date: TextView = itemView.findViewById(R.id.tvmatchD)
        val time: TextView = itemView.findViewById(R.id.tvmatchT)
        val container: NativeAdLayout = itemView.findViewById(R.id.fb_native_ad_container)
    }
}
