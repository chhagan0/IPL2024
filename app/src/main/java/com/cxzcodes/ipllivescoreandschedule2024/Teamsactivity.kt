package com.cxzcodes.ipllivescoreandschedule2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.cxzcodes.ipllivescoreandschedule2024.Ads.BannerADs
import com.cxzcodes.ipllivescoreandschedule2024.adapter.ItemAdapter
import com.cxzcodes.ipllivescoreandschedule2024.databinding.ActivityTeamsactivityBinding
import com.cxzcodes.ipllivescoreandschedule2024.model.ModelClass

class Teamsactivity : AppCompatActivity() {
    lateinit var binding:ActivityTeamsactivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityTeamsactivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivbtnback.setOnClickListener { finish() }
//BannerADs.bannerADShow(this,binding.adView)
        val items = listOf(
            ModelClass("CSK", R.drawable.csk),
            ModelClass("MI", R.drawable.mi),
            ModelClass("KKR", R.drawable.kkr),
            ModelClass("SRH", R.drawable.srh),
            ModelClass("RR", R.drawable.rr),
            ModelClass("RCB", R.drawable.rcb),
            ModelClass("DC", R.drawable.dc),
            ModelClass("PBKS", R.drawable.pbks),
            ModelClass("LSG", R.drawable.lsg),
            ModelClass("GT", R.drawable.gt),
         )



        val adapter = ItemAdapter(items,this)
//        val admobNativeAdAdapter = AdmobNativeAdAdapter.Builder.with(
//            this.resources.getString(R.string.native_id),
//            adapter,
//            "small"   // "medium" it can also used
//        ).adItemInterval(4).build()
//        binding.rvteams.layoutManager = GridLayoutManager(this, 2) // Change the span count as needed
//
//        binding.rvteams.adapter  = admobNativeAdAdapter


        binding.rvteams.layoutManager = GridLayoutManager(this, 2) // Change the span count as needed
        binding.rvteams.adapter = adapter
    }
}