package com.cxzcodes.ipllivescoreandschedule2024

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.cxzcodes.ipllivescoreandschedule2024.adapter.ItemAdapter
import com.cxzcodes.ipllivescoreandschedule2024.adapter.ScheduleTeams
import com.cxzcodes.ipllivescoreandschedule2024.databinding.ActivityScheduleBinding
import com.cxzcodes.ipllivescoreandschedule2024.model.ModelClass

class ScheduleTeams : AppCompatActivity() {
    lateinit var binding:ActivityScheduleBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityScheduleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivbtnback.setOnClickListener { finish() }

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
        var adapter= ScheduleTeams(items,this)


        binding.recyclerview.layoutManager = GridLayoutManager(this, 2) // Change the span count as needed
        binding.recyclerview.adapter = adapter
    }
}