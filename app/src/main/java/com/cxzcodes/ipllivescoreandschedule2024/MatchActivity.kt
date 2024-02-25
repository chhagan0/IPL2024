package com.cxzcodes.ipllivescoreandschedule2024

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cxzcodes.ipllivescoreandschedule2024.adapter.MatchAdapter
import com.cxzcodes.ipllivescoreandschedule2024.adapter.ScheduleAdapter
import com.cxzcodes.ipllivescoreandschedule2024.adapter.ScheduleTeams
import com.cxzcodes.ipllivescoreandschedule2024.adapter.TeamAdapter
import com.cxzcodes.ipllivescoreandschedule2024.databinding.ActivityMatchBinding
import com.cxzcodes.ipllivescoreandschedule2024.model.MatchModel
import com.google.android.ads.nativetemplates.rvadapter.AdmobNativeAdAdapter

class MatchActivity : AppCompatActivity() {
    lateinit var binding:ActivityMatchBinding
    var items:List<MatchModel> = listOf()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMatchBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivbtnback.setOnClickListener { finish() }
        val team=intent.getStringExtra("name")
         if (team=="CSK"){
            items= listOf(
                MatchModel("Match 1","07:30 PM","31 March 2024","Narendra Modi Stadium", R.drawable.gt,R.drawable.csk),
                MatchModel("Match 2","07:30 PM","3 April 2024","MA Chidambaram Stadium",R.drawable.csk,R.drawable.lsg),
                MatchModel("Match 3","07:30 PM","8 April 2024","Wankhede Stadium",R.drawable.mi,R.drawable.csk),
                MatchModel("Match 4","07:30 PM","12 April 2024","MA Chidambaram Stadium",R.drawable.csk,R.drawable.rr),
                MatchModel("Match 5","07:30 PM","17 April 2024","M Chinnaswamy Stadium",R.drawable.rcb,R.drawable.csk),
                MatchModel("Match 6","07:30 PM","21 April 2024","MA Chidambaram Stadium",R.drawable.csk,R.drawable.srh),
                MatchModel("Match 7","07:30 PM","23 April 2024","Eden Gardens Stadium",R.drawable.kkr,R.drawable.csk),
                MatchModel("Match 8","07:30 PM","27 April 2024","Sawai Mansingh Stadium",R.drawable.csk,R.drawable.rr),
                MatchModel("Match 9","03:30 PM","30 April 2024","MA Chidambaram Stadium",R.drawable.pbks,R.drawable.csk),
                MatchModel("Match 10","03:30 PM","04 May 2024","Atal Bihari Stadium",R.drawable.csk,R.drawable.lsg),
                MatchModel("Match 11","03:30 PM","06 May 2024","MA Chidambaram Stadium",R.drawable.dc,R.drawable.csk),
                MatchModel("Match 12","07:30 PM","10 May 2024","MA Chidambaram Stadium",R.drawable.csk,R.drawable.dc),
                MatchModel("Match 13","07:30 PM","14 May 2024","MA Chidambaram Stadium",R.drawable.kkr,R.drawable.csk),
                MatchModel("Match 14","03:30 PM","20 May 2024","Arun Jaitley Stadium",R.drawable.csk,R.drawable.dc),
              )
        }else if (team=="MI"){
             items= listOf(
                 MatchModel("Match 1","03:30 PM","02 April 2024","Rajiv Gandhi Stadium", R.drawable.mi,R.drawable.csk),
                 MatchModel("Match 2","07:30 PM","07 April 2024","Atal Bihari Stadium",R.drawable.csk,R.drawable.mi),
                 MatchModel("Match 3","07:30 PM","09 April 2024","Rajiv Gandhi Stadium",R.drawable.mi,R.drawable.csk),
                 MatchModel("Match 4","07:30 PM","14 April 2024","Eden Gardens Stadium",R.drawable.csk,R.drawable.mi),
                 MatchModel("Match 5","07:30 PM","18 April 2024","Rajiv Gandhi Stadium",R.drawable.mi,R.drawable.csk),
                 MatchModel("Match 6","07:30 PM","21 April 2024","MA Chidambaram Stadium",R.drawable.csk,R.drawable.mi),
                 MatchModel("Match 7","07:30 PM","24 April 2024","Rajiv Gandhi Stadium",R.drawable.mi,R.drawable.csk),
                 MatchModel("Match 8","07:30 PM","29 April 2024","Arun Jaitley Stadium",R.drawable.csk,R.drawable.mi),
                 MatchModel("Match 9","07:30 PM","04 May 2024","Rajiv Gandhi Stadium",R.drawable.mi,R.drawable.csk),
                 MatchModel("Match 10","07:30 PM","07 May 2024","Sawai Mansingh Stadium",R.drawable.csk,R.drawable.mi),
                 MatchModel("Match 11","03:30 PM","13 May 2024","Rajiv Gandhi Stadium",R.drawable.mi,R.drawable.csk),
                 MatchModel("Match 12","07:30 PM","15 May 2024","Narendra Modi Stadium",R.drawable.csk,R.drawable.mi),
                 MatchModel("Match 13","07:30 PM","18 May 2024","Rajiv Gandhi Stadium",R.drawable.mi,R.drawable.csk),
                 MatchModel("Match 14","03:30 PM","21 May 2024","Wankhede Stadium",R.drawable.csk,R.drawable.mi),
             )

        }else if (team=="KKR"){
             items= listOf(
                 MatchModel("Match 1","03:30 PM","02 April 2024","Rajiv Gandhi Stadium", R.drawable.rr,R.drawable.srh),
                 MatchModel("Match 2","07:30 PM","05 April 2024","Atal Bihari Stadium",R.drawable.pbks,R.drawable.rr),
                 MatchModel("Match 3","03:30 PM","08 April 2024","Rajiv Gandhi Stadium",R.drawable.rr,R.drawable.dc),
                 MatchModel("Match 4","07:30 PM","12 April 2024","Eden Gardens Stadium",R.drawable.csk,R.drawable.rr),
                 MatchModel("Match 5","07:30 PM","16 April 2024","Rajiv Gandhi Stadium",R.drawable.rr,R.drawable.gt),
                 MatchModel("Match 6","07:30 PM","19 April 2024","MA Chindambaram Stadium",R.drawable.lsg,R.drawable.rr),
                 MatchModel("Match 7","03:30 PM","23 April 2024","Rajiv Gandhi Stadium",R.drawable.rr,R.drawable.rcb),
                 MatchModel("Match 8","07:30 PM","27 April 2024","Arun Jaitley Stadium",R.drawable.csk,R.drawable.rr),
                 MatchModel("Match 9","07:30 PM","30 April 2024","Rajiv Gandhi Stadium",R.drawable.rr,R.drawable.mi),
                 MatchModel("Match 10","07:30 PM","05 May 2024","Sawai Mansingh Stadium",R.drawable.gt,R.drawable.rr),
                 MatchModel("Match 11","03:30 PM","07 May 2024","Rajiv Gandhi Stadium",R.drawable.rr,R.drawable.srh),
                 MatchModel("Match 12","07:30 PM","11 May 2024","Narendra Modi Stadium",R.drawable.kkr,R.drawable.rr),
                 MatchModel("Match 13","03:30 PM","14 May 2024","Rajiv Gandhi Stadium",R.drawable.rr,R.drawable.rcb),
                 MatchModel("Match 14","03:30 PM","19 May 2024","Wankhede Stadium",R.drawable.pbks,R.drawable.rr),
             )

        }else if (team=="SRH"){

             items= listOf(
                 MatchModel("Match 1","03:30 PM","02 April 2024","Rajiv Gandhi Stadium", R.drawable.srh,R.drawable.rr),
                 MatchModel("Match 2","07:30 PM","07 April 2024","Atal Bihari Stadium",R.drawable.lsg,R.drawable.srh),
                 MatchModel("Match 3","07:30 PM","09 April 2024","Rajiv Gandhi Stadium",R.drawable.srh,R.drawable.pbks),
                 MatchModel("Match 4","07:30 PM","14 April 2024","Eden Gardens Stadium",R.drawable.kkr,R.drawable.srh),
                 MatchModel("Match 5","07:30 PM","18 April 2024","Rajiv Gandhi Stadium",R.drawable.srh,R.drawable.mi),
                 MatchModel("Match 6","07:30 PM","21 April 2024","MA Chindambaram Stadium",R.drawable.csk,R.drawable.srh),
                 MatchModel("Match 7","07:30 PM","24 April 2024","Rajiv Gandhi Stadium",R.drawable.srh,R.drawable.dc),
                 MatchModel("Match 8","07:30 PM","29 April 2024","Arun Jaitley Stadium",R.drawable.dc,R.drawable.srh),
                 MatchModel("Match 9","07:30 PM","04 May 2024","Rajiv Gandhi Stadium",R.drawable.srh,R.drawable.kkr),
                 MatchModel("Match 10","07:30 PM","07 May 2024","Sawai Mansingh Stadium",R.drawable.rr,R.drawable.srh),
                 MatchModel("Match 11","03:30 PM","13 May 2024","Rajiv Gandhi Stadium",R.drawable.srh,R.drawable.lsg),
                 MatchModel("Match 12","07:30 PM","15 May 2024","Narendra Modi Stadium",R.drawable.gt,R.drawable.srh),
                 MatchModel("Match 13","07:30 PM","18 May 2024","Rajiv Gandhi Stadium",R.drawable.srh,R.drawable.lsg),
                 MatchModel("Match 14","03:30 PM","21 May 2024","Wankhede Stadium",R.drawable.mi,R.drawable.srh),
             )

        }else if (team=="RR"){

             items= listOf(
                 MatchModel("Match 1","03:30 PM","02 April 2024","Rajiv Gandhi Stadium", R.drawable.rr,R.drawable.srh),
                 MatchModel("Match 2","07:30 PM","05 April 2024","Barsapara Cricket Stadium",R.drawable.pbks,R.drawable.rr),
                 MatchModel("Match 3","03:30 PM","08 April 2024","Barsapara Cricket Stadium",R.drawable.rr,R.drawable.dc),
                 MatchModel("Match 4","07:30 PM","12 April 2024","MA Chindambaram Stadium",R.drawable.csk,R.drawable.rr),
                 MatchModel("Match 5","07:30 PM","16 April 2024","Narendra Modi Stadium",R.drawable.rr,R.drawable.gt),
                 MatchModel("Match 6","07:30 PM","19 April 2024","Sawai Mansingh Stadium",R.drawable.lsg,R.drawable.rr),
                 MatchModel("Match 7","03:30 PM","23 April 2024","M Chinnaswamy Stadium",R.drawable.rr,R.drawable.rcb),
                 MatchModel("Match 8","07:30 PM","27 April 2024","Sawai Mansingh Stadium",R.drawable.csk,R.drawable.rr),
                 MatchModel("Match 9","07:30 PM","30 April 2024","Wankhede Stadium",R.drawable.rr,R.drawable.mi),
                 MatchModel("Match 10","07:30 PM","05 May 2024","Sawai Mansingh Stadium",R.drawable.gt,R.drawable.rr),
                 MatchModel("Match 11","03:30 PM","07 May 2024","Sawai Mansingh Stadium",R.drawable.rr,R.drawable.srh),
                 MatchModel("Match 12","07:30 PM","11 May 2024","Eden Gardens Stadium",R.drawable.kkr,R.drawable.rr),
                 MatchModel("Match 13","03:30 PM","14 May 2024","Sawai Mansingh Stadium",R.drawable.rr,R.drawable.rcb),
                 MatchModel("Match 14","03:30 PM","19 May 2024","Himachal Pradesh Stadium",R.drawable.pbks,R.drawable.rr),
             )

        }else if (team=="RCB"){
             items= listOf(
                 MatchModel("Match 1","07:30 PM","02 April 2024","M Chinnaswamy Stadium", R.drawable.rcb,R.drawable.mi),
                 MatchModel("Match 2","07:30 PM","06 April 2024","Eden Gardens Stadium",R.drawable.kkr,R.drawable.rcb),
                 MatchModel("Match 3","07:30 PM","10 April 2024","M Chinnaswamy Stadium",R.drawable.rcb,R.drawable.lsg),
                 MatchModel("Match 4","03:30 PM","15 April 2024","M Chinnaswamy Stadium",R.drawable.dc,R.drawable.rcb),
                 MatchModel("Match 5","07:30 PM","17 April 2024","M Chinnaswamy Stadium",R.drawable.rcb,R.drawable.csk),
                 MatchModel("Match 6","03:30 PM","20 April 2024","Punjab Cricket Stadium",R.drawable.pbks,R.drawable.rcb),
                 MatchModel("Match 7","03:30 PM","23 April 2024","M Chinnaswamy Stadium",R.drawable.rcb,R.drawable.rr),
                 MatchModel("Match 8","07:30 PM","26 April 2024","M Chinnaswamy Stadium",R.drawable.kkr,R.drawable.rcb),
                 MatchModel("Match 9","07:30 PM","01 May 2024","Atal Bihari Stadium",R.drawable.rcb,R.drawable.lsg),
                 MatchModel("Match 10","07:30 PM","06 May 2024","Arun Jaitley Stadium",R.drawable.dc,R.drawable.rcb),
                 MatchModel("Match 11","07:30 PM","09 May 2024","Wankhede Stadium",R.drawable.rcb,R.drawable.mi),
                 MatchModel("Match 12","03:30 PM","14 May 2024","Sawai Mansingh Stadium",R.drawable.rr,R.drawable.rcb),
                 MatchModel("Match 13","07:30 PM","18 May 2024","Sawai Mansingh Stadium",R.drawable.rcb,R.drawable.lsg),
                 MatchModel("Match 14","07:30 PM","21 May 2024","M Chinnaswamy Stadium",R.drawable.gt,R.drawable.rcb),
             )


        }else if (team=="DC"){
             items= listOf(
                 MatchModel("Match 1","03:30 PM","01 April 2024","Atal Bihari Stadium", R.drawable.dc,R.drawable.lsg),
                 MatchModel("Match 2","07:30 PM","04 April 2024","Arun Jaitley Stadium",R.drawable.gt,R.drawable.dc),
                 MatchModel("Match 3","03:30 PM","08 April 2024","Barsapara Cricket Stadium",R.drawable.dc,R.drawable.rr),
                 MatchModel("Match 4","07:30 PM","11 April 2024","Arun Jaitley Stadium",R.drawable.mi,R.drawable.dc),
                 MatchModel("Match 5","03:30 PM","15 April 2024","M Chinnaswamy Stadium",R.drawable.dc,R.drawable.rcb),
                 MatchModel("Match 6","07:30 PM","20 April 2024","Arun Jaitley Stadium",R.drawable.kkr,R.drawable.dc),
                 MatchModel("Match 7","07:30 PM","24 April 2024","Rajiv Gandhi Stadium",R.drawable.dc,R.drawable.srh),
                 MatchModel("Match 8","07:30 PM","29 April 2024","Arun Jaitley Stadium",R.drawable.srh,R.drawable.dc),
                 MatchModel("Match 9","07:30 PM","02 May 2024","Narendra Modi Stadium",R.drawable.dc,R.drawable.gt),
                 MatchModel("Match 10","07:30 PM","06 May 2024","Arun Jaitley Stadium",R.drawable.rcb,R.drawable.dc),
                 MatchModel("Match 11","07:30 PM","10 May 2024","MA Chidambaram Stadium",R.drawable.dc,R.drawable.dc),
                 MatchModel("Match 12","07:30 PM","13 May 2024","Arun Jaitley Stadium",R.drawable.pbks,R.drawable.dc),
                 MatchModel("Match 13","07:30 PM","17 May 2024","Himachal Pradesh Stadium",R.drawable.dc,R.drawable.pbks),
                 MatchModel("Match 14","03:30 PM","20 May 2024","Arun Jaitley Stadium",R.drawable.csk,R.drawable.dc),
             )


        }else if (team=="PBKS"){
             items= listOf(
                 MatchModel("Match 1","03:30 PM","01 April 2024","Punjab Cricket Stadium", R.drawable.pbks,R.drawable.kkr),
                 MatchModel("Match 2","07:30 PM","05 April 2024","Barsapara Cricket Stadium",R.drawable.rr,R.drawable.pbks),
                 MatchModel("Match 3","07:30 PM","09 April 2024","Rajiv Gandhi Stadium",R.drawable.pbks,R.drawable.srh),
                 MatchModel("Match 4","07:30 PM","13 April 2024","Punjab Cricket Stadium",R.drawable.gt,R.drawable.pbks),
                 MatchModel("Match 5","07:30 PM","15 April 2024","Atal Bihari Stadium",R.drawable.pbks,R.drawable.lsg),
                 MatchModel("Match 6","03:30 PM","20 April 2024","Punjab Cricket Stadium",R.drawable.rcb,R.drawable.pbks),
                 MatchModel("Match 7","07:30 PM","22 April 2024","Wankhede Stadium",R.drawable.pbks,R.drawable.mi),
                 MatchModel("Match 8","07:30 PM","28 April 2024","Punjab Cricket Stadium",R.drawable.lsg,R.drawable.pbks),
                 MatchModel("Match 9","03:30 PM","30 April 2024","MA Chidambaram Stadium",R.drawable.pbks,R.drawable.csk),
                 MatchModel("Match 10","07:30 PM","03 May 2024","Punjab Cricket Stadium",R.drawable.mi,R.drawable.pbks),
                 MatchModel("Match 11","07:30 PM","08 May 2024","Eden Gardens Stadium",R.drawable.pbks,R.drawable.kkr),
                 MatchModel("Match 12","07:30 PM","13 May 2024","Arun Jaitley Stadium",R.drawable.dc,R.drawable.pbks),
                 MatchModel("Match 13","07:30 PM","17 May 2024","Himachal Pradesh Stadium",R.drawable.pbks,R.drawable.dc),
                 MatchModel("Match 14","07:30 PM","19 May 2024","Himachal Pradesh Stadium",R.drawable.rr,R.drawable.pbks),
             )


        }else if (team=="LSG"){

             items= listOf(
                 MatchModel("Match 1","07:30 PM","01 April 2024","Atal Bihari Stadium", R.drawable.lsg,R.drawable.dc),
                 MatchModel("Match 2","07:30 PM","03 April 2024","MA Chindambaram Stadium",R.drawable.csk,R.drawable.lsg),
                 MatchModel("Match 3","07:30 PM","07 April 2024","Atal Bihari Stadium",R.drawable.lsg,R.drawable.srh),
                 MatchModel("Match 4","07:30 PM","10 April 2024","M Chinnaswamy Stadium",R.drawable.srh,R.drawable.lsg),
                 MatchModel("Match 5","07:30 PM","15 April 2024","Atal Bihari Stadium",R.drawable.lsg,R.drawable.pbks),
                 MatchModel("Match 6","07:30 PM","19 April 2024","Swai Mansingh Stadium",R.drawable.rr,R.drawable.lsg),
                 MatchModel("Match 7","03:30 PM","22 April 2024","Atal Bihari Stadium",R.drawable.lsg,R.drawable.gt),
                 MatchModel("Match 8","07:30 PM","28 April 2024","Pubjab Cricket Stadium",R.drawable.pbks,R.drawable.lsg),
                 MatchModel("Match 9","07:30 PM","01 May 2024","Atal Bihari Stadium",R.drawable.lsg,R.drawable.rcb),
                 MatchModel("Match 10","03:30 PM","04 May 2024","Atal Bihari Stadium",R.drawable.csk,R.drawable.lsg),
                 MatchModel("Match 11","03:30 PM","07 May 2024","Narendra Modi Stadium",R.drawable.lsg,R.drawable.gt),
                 MatchModel("Match 12","03:30 PM","13 May 2024","Rajiv Gandhi Stadium",R.drawable.srh,R.drawable.lsg),
                 MatchModel("Match 13","07:30 PM","16 May 2024","Atal Bihari Stadium",R.drawable.lsg,R.drawable.mi),
                 MatchModel("Match 14","07:30 PM","20 May 2024","Eden Gardens Stadium",R.drawable.kkr,R.drawable.lsg),
             )

        }else if (team=="GT"){

             items= listOf(
                 MatchModel("Match 1","07:30 PM","31 March 2024","Narendra Modi Stadium", R.drawable.gt,R.drawable.csk),
                 MatchModel("Match 2","07:30 PM","04 April 2024","Arun Jaitley Stadium",R.drawable.dc,R.drawable.gt),
                 MatchModel("Match 3","03:30 PM","09 April 2024","Narendra Modi Stadium",R.drawable.gt,R.drawable.kkr),
                 MatchModel("Match 4","07:30 PM","13 April 2024","Punjab Cricket Stadium",R.drawable.pbks,R.drawable.gt),
                 MatchModel("Match 5","07:30 PM","16 April 2024","Narendra Modi Stadium",R.drawable.gt,R.drawable.rr),
                 MatchModel("Match 6","03:30 PM","22 April 2024","Atal Bihari Stadium",R.drawable.lsg,R.drawable.gt),
                 MatchModel("Match 7","07:30 PM","25 April 2024","Narendra Modi Stadium",R.drawable.gt,R.drawable.mi),
                 MatchModel("Match 8","03:30 PM","29 April 2024","Eden Gardens Stadium",R.drawable.kkr,R.drawable.gt),
                 MatchModel("Match 9","07:30 PM","02 May 2024","Narendra Modi Stadium",R.drawable.gt,R.drawable.dc),
                 MatchModel("Match 10","07:30 PM","05 May 2024","Swai Mansingh Stadium",R.drawable.rr,R.drawable.gt),
                 MatchModel("Match 11","03:30 PM","07 May 2024","Narendra Modi Stadium",R.drawable.gt,R.drawable.lsg),
                 MatchModel("Match 12","07:30 PM","12 May 2024","Wankhede Stadium",R.drawable.mi,R.drawable.gt),
                 MatchModel("Match 13","07:30 PM","15 May 2024","Narendra Modi Stadium",R.drawable.gt,R.drawable.srh),
                 MatchModel("Match 14","07:30 PM","21 May 2024","M Chinaswamy Stadium",R.drawable.rcb,R.drawable.gt),
             )

        }

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val admob = sharedPreferences.getBoolean("ADMOB", true)
        val fbads = sharedPreferences.getBoolean("FBADS", true)

        if (admob==true){
            val adapter = MatchAdapter(items, this,false)

            val admobNativeAdAdapter = AdmobNativeAdAdapter.Builder.with(
                this.resources.getString(R.string.native_id),
                adapter,
                "medium"   // "medium" it can also used
            ).adItemInterval(4).build()
            binding.recyclerview.layoutManager = LinearLayoutManager(this)

            binding.recyclerview.adapter = admobNativeAdAdapter
        }else if (fbads==true){
                    var adapter = MatchAdapter(items, this,fbads)

            binding.recyclerview.layoutManager = LinearLayoutManager(this)
        binding.recyclerview.adapter = adapter
        }

    }
}