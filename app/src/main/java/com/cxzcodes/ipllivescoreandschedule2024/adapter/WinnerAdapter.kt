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
import com.cxzcodes.ipllivescoreandschedule2024.model.TeamModel
import com.cxzcodes.ipllivescoreandschedule2024.model.WinnerModel
import com.facebook.ads.NativeAdLayout

class WinnerAdapter(private val items: List<WinnerModel>, val context: Context,val ads:Boolean) :
    RecyclerView.Adapter<WinnerAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_winner, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        if (ads==true){
            if ((position + 1) % 5 == 0) {
                holder.container.visibility = View.VISIBLE
                FbNativeADs.loadNativeAd(context, holder.container)
            } else {
                holder.container.visibility = View.GONE

            }

        }

        holder.winner.text = item.winnerteam
        holder.looser.text = item.looserteam
        holder.year.text=item.year
        Glide.with(context).load(item.imageurl)
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>,
                    isFirstResource: Boolean
                ): Boolean {
                    holder.progressbar.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable,
                    model: Any,
                    target: Target<Drawable>?,
                    dataSource: DataSource,
                    isFirstResource: Boolean
                ): Boolean {
                    holder.progressbar.visibility = View.GONE
                    return false
                }

            })
            .into(holder.imageView);

        holder.itemView.setOnClickListener {
            // Handle item click
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.ivteamposter)
        val winner: TextView = itemView.findViewById(R.id.tvwinnerteam)
        val looser: TextView = itemView.findViewById(R.id.tvlooserteam)
        val year: TextView = itemView.findViewById(R.id.tvyear)
        val progressbar: ProgressBar = itemView.findViewById(R.id.progressBar)
        val container: NativeAdLayout =itemView.findViewById(R.id.fb_native_ad_container)

    }
}
