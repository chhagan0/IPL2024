package com.cxzcodes.ipllivescoreandschedule2024

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cxzcodes.ipllivescoreandschedule2024.adapter.MatchAdapter
import com.cxzcodes.ipllivescoreandschedule2024.adapter.ScheduleAdapter
import com.cxzcodes.ipllivescoreandschedule2024.databinding.ActivityScheduleBinding
import com.cxzcodes.ipllivescoreandschedule2024.model.ScheduleModel
import com.google.android.ads.nativetemplates.rvadapter.AdmobNativeAdAdapter

class VenusActivity : AppCompatActivity() {
    lateinit var binding: ActivityScheduleBinding
    var items: List<ScheduleModel> = listOf()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        items = listOf(
            ScheduleModel(
                "Narendra Modi Statius",
                "Place : Ahmendabad",
                "https://gujaratcricketassociation.com/wp-content/uploads/2020/02/main-image.jpg"
            ),
            ScheduleModel(
                "Punjab Cricket Association",
                "Place : Mohali",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSoSTuvd2PBW_Of39dS-ryShW6nTREaoVc1hg&usqp=CAU"
            ),
            ScheduleModel(
                "Bharat Ratan Stadium",
                "Place : Lucknow",
                "https://static.toiimg.com/photo/103995682.cms"
            ),
            ScheduleModel(
                "Rajiv Gandhi Stadium",
                "Place : Hyderabad",
                "https://resources.pulse.icc-cricket.com/ICC/photo/2023/10/06/66541019-fca3-4d50-a2e2-e6ffee5e12dd/gvKxdIZA.jpg"
            ),
            ScheduleModel(
                "M.Chinnaswamy Stadium",
                "Place : Bengaluru",
                "https://img1.hscicdn.com/image/upload/f_auto,t_ds_wide_w_640,q_50/lsci/db/PICTURES/CMS/127600/127631.jpg"
            ),
            ScheduleModel(
                "MA Chidambaram Stadium",
                "Place : Chennai",
                "https://www.iplt20.com/assets/images/stadiumimage/Chennai-new.jpg"
            ),
            ScheduleModel(
                "Arun Jaitley Stadium",
                "Place : Delhi",
                "https://www.hindustantimes.com/ht-img/img/2023/08/06/1600x900/DDCA--which-owns-and-operates-the-Arun-Jaitley-Sta_1691346611844.jpg"
            ),
            ScheduleModel(
                "Barsapara Cricket Stadium",
                "Place : Guwahati",
                "https://media.crictracker.com/media/featureimage/2017/10/Guwahati-Stadium.jpg"
            ),
            ScheduleModel(
                "Eden Gardens",
                "Place : Kolkata",
                "https://www.iplt20.com/assets/images/stadiumimage/eden-garden-small-new.jpg"
            ),
            ScheduleModel(
                "Wankhede Stadium",
                "Place : Mumbai",
                "https://www.iplt20.com/assets/images/stadiumimage/Wankhede-Stadium-new.jpg"
            ),
            ScheduleModel(
                "Sawai Mansingh Stadium",
                "Place : Jaipur",
                "https://www.sportsadda.com/static-assets/waf-images/25/e1/7d/16-9/PwVwBXYrnX.jpg?v=1.6&w=420%20420w"
            ),
            ScheduleModel(
                "Himachal Pradesh Cricket",
                "Place : Dharamsala",
                "https://m.economictimes.com/thumb/msid-103977020,width-1600,height-900,resizemode-4,imgsize-326036/dharamshala-hpca-stadium-on-the-eve-of-ipl-2023-cricket-match-between-punjab-ki-.jpg"
            )
        )
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val admob = sharedPreferences.getBoolean("ADMOB", true)
        val fbads = sharedPreferences.getBoolean("FBADS", true)


        if (admob==true){
            val adapter = ScheduleAdapter(items, this,false)
            val admobNativeAdAdapter = AdmobNativeAdAdapter.Builder.with(
                this.resources.getString(R.string.native_id),
                adapter,
                "medium"   // "medium" it can also used
            ).adItemInterval(4).build()
            binding.recyclerview.layoutManager = LinearLayoutManager(this)

            binding.recyclerview.adapter = admobNativeAdAdapter
        }else if (fbads==true){
            var adapter = ScheduleAdapter(items, this,fbads)


            binding.recyclerview.layoutManager = LinearLayoutManager(this)
            binding.recyclerview.adapter = adapter
        }


        binding.ivbtnback.setOnClickListener { finish() }
    }
}