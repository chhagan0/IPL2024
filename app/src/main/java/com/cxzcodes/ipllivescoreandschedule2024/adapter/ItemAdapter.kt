package com.cxzcodes.ipllivescoreandschedule2024.adapter

 import android.content.Context
 import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
 import com.cxzcodes.TeamDetails
 import com.cxzcodes.ipllivescoreandschedule2024.Ads.InterstitialADs
 import com.cxzcodes.ipllivescoreandschedule2024.MatchActivity
 import com.cxzcodes.ipllivescoreandschedule2024.R
 import com.cxzcodes.ipllivescoreandschedule2024.model.ModelClass

class ItemAdapter(private val items: List<ModelClass>,val context:Context) : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_teams, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items[position]

        holder.imageView.setImageResource(item.teampic)
        holder.textViewName.text = items[position].teamname
        holder.itemView.setOnClickListener {
            val intent = android.content.Intent(context, TeamDetails::class.java)
            intent.putExtra("name", item.teamname)
            if ((position + 1) % 4 == 0) {
                InterstitialADs.showInter(context, intent)
            } else {
                context.startActivity(intent)

            }

        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.ivteamlogo)
        val textViewName: TextView = itemView.findViewById(R.id.tvteamname)
    }
}
