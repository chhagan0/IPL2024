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
import com.facebook.ads.NativeAdLayout

class TeamAdapter(private val items: List<TeamModel>, val context: Context,val ads:Boolean) :
    RecyclerView.Adapter<TeamAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_teamsdetails, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]
        if (ads==true){
            if ((position + 1) % 5 == 0) {
                holder.container.visibility=View.VISIBLE
                FbNativeADs.loadNativeAd(context, holder.container)
            }else{
                holder.container.visibility=View.GONE

            }

        }
        holder.textViewName.text = items[position].teamname
        holder.textpos.text = item.position
        holder.runrate.text = item.runrate
        holder.totalscore.text = item.totalScore
        holder.Imagepos.setImageResource(item.imagepos)
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
        val imageView: ImageView = itemView.findViewById(R.id.ivphoto)
        val textViewName: TextView = itemView.findViewById(R.id.tvname)
        val progressbar: ProgressBar = itemView.findViewById(R.id.progressBar)
        val Imagepos: ImageView = itemView.findViewById(R.id.ivposition)
        val textpos: TextView = itemView.findViewById(R.id.tvposition)
        val totalscore: TextView = itemView.findViewById(R.id.tvtotalScore)
        val runrate: TextView = itemView.findViewById(R.id.tvrunrate)
        val container: NativeAdLayout = itemView.findViewById(R.id.fb_native_ad_container)
    }
}
