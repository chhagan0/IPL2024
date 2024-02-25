package com.cxzcodes.ipllivescoreandschedule2024

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.cxzcodes.ipllivescoreandschedule2024.adapter.TeamAdapter
import com.cxzcodes.ipllivescoreandschedule2024.adapter.WinnerAdapter
import com.cxzcodes.ipllivescoreandschedule2024.databinding.ActivityWinnerBinding
import com.cxzcodes.ipllivescoreandschedule2024.model.TeamModel
import com.cxzcodes.ipllivescoreandschedule2024.model.WinnerModel
import com.google.android.ads.nativetemplates.rvadapter.AdmobNativeAdAdapter

class WinnerActivity : AppCompatActivity() {
    private lateinit var binding:ActivityWinnerBinding
    var items: List<WinnerModel> = listOf()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityWinnerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val admob = sharedPreferences.getBoolean("ADMOB", true)
        val fbads = sharedPreferences.getBoolean("FBADS", true)
        items= listOf(
            WinnerModel("Chennai Super Kings Won","BY : Gujarat Titans ","2023","https://newsroompost.com/wp-content/uploads/2023/05/CSK-victory.jpg"),
            WinnerModel("Gujrat Titans Won","BY : Rajasthan","2022","https://th.bing.com/th/id/OIP.FvUqaawmVG1pWSorDqWX9AHaEK?rs=1&pid=ImgDetMain"),
            WinnerModel("Chennai Super Kings Won","By : Kolkata Knight Riders","2021","https://th.bing.com/th/id/OIP.wEC2HbL733-3XU-xGarHRAHaE8?rs=1&pid=ImgDetMain"),
            WinnerModel("Mumbai Indian Won","BY : Delhi Capitals","2020","https://th.bing.com/th/id/OIP.2XrWmijGLtIl0vvxE4EZGgHaEK?rs=1&pid=ImgDetMain"),
            WinnerModel("Mumbai Indian Won","BY : Delhi Capitals","2019","https://static-ai.asianetnews.com/images/01daqktsq8rq7196qdz9z7yhgz/Mumbai-Indians--IPL-2019_710x400xt.jpg"),
            WinnerModel("Chennai Super Kings Won ","BY : Sunrises Hyderabad","2018","https://th.bing.com/th/id/R.fd6db86ff5208c9ae2cf3aac2e1ff417?rik=py65%2fv2xac6Q0Q&riu=http%3a%2f%2fimages.indianexpress.com%2f2018%2f05%2f152.jpg&ehk=GR%2fH03%2fuxvkggZDAE%2fuoZ2g6%2bdp9G5SvtY0Hml6iSGs%3d&risl=&pid=ImgRaw&r=0"),
            WinnerModel("Mumbai Indian Won ","BY : Rising Pune Super giants","2017","https://cdn.images.express.co.uk/img/dynamic/68/590x/IPL-final-2017-Rising-Pune-Supergiant-captain-Steve-Smith-and-Mumbai-Indians-captain-Rohit-Sharma-807302.jpg"),
            WinnerModel("Sunrise Hyderabad Won ","BY : Royal Challengers Bangalore ","2016 ","https://th.bing.com/th/id/R.eae454143a88708bd538c7916b7a9ed3?rik=PgL%2fu%2fqTx%2bQifA&riu=http%3a%2f%2fdata1.ibtimes.co.in%2fcache-img-700-389%2fen%2ffull%2f609008%2f1464579172_sunrisers-hyderabad.jpg&ehk=r8ChLgkdqZKUnbifAKFGWm1F9UFQ6QmNX9xHmZ4mTKo%3d&risl=&pid=ImgRaw&r=0"),
            WinnerModel("Mumbai Indian Won ","BY : Chennai Super Kings ","2015","https://th.bing.com/th/id/R.4dc395267d369dd812ae2e9e51f9c62c?rik=G13ufCbINeqI3A&riu=http%3a%2f%2fwww.ipltickets.net%2fwp-content%2fuploads%2f2015%2f05%2fipl-2015-winners.jpg&ehk=WR5JGEz4nuBGt%2bzCG1P5qWM%2fVTptkl7K4gbXTikx2Pw%3d&risl=&pid=ImgRaw&r=0"),
            WinnerModel("Kolkata Knight Riders ","BY : Kings XI Punjabi ","2014 ","https://www.100mbsports.com/wp-content/uploads/2020/08/Kolkata-Knight-Riders-win-IPL-1-e1598089570530.jpg"),
            WinnerModel("Mumbai Indian Won ","BY : Chennai Super Kings ","2013 ","https://th.bing.com/th/id/R.2b4239df6a40ccc8ae28d85b44d69c5c?rik=sep%2bWZ%2fRtZMSoA&riu=http%3a%2f%2f2.bp.blogspot.com%2f-i-Nf4sKDohg%2fUaLM5eJ5y-I%2fAAAAAAAAGZU%2faQ0gL-FpYj4%2fs1600%2fmumbai-indians-ipl-2013-winners-2.jpg&ehk=0fn%2f6RgahqBq9u4C0R84gIpBN7J5unjkb2Dft9MYHU8%3d&risl=&pid=ImgRaw&r=0"),
            WinnerModel("Kolkata Knight Riders Won","BY : Chennai Super Kings ","2012","https://static.sportskeeda.com/wp-content/uploads/2014/01/uy-2084793.jpg"),
            WinnerModel("Chennai Super Kings Won","BY : Royal Challengers Bangalore ","2011","https://1.bp.blogspot.com/-UmfUqkSkmCA/TeHOxX2--kI/AAAAAAAAU_4/uz9ZZ4aokk0/s1600/csk1.jpg"),
            WinnerModel("Chennai Super Kings Won","BY : Mumbai Indian ","2010","https://img1.hscicdn.com/image/upload/f_auto,t_ds_w_1200/lsci/db/PICTURES/CMS/321800/321894.png"),
            WinnerModel("Deccan","BY : Royal Challengers Bangalore ","2009 ","https://i2.wp.com/www.rajasthandirect.com/wp-content/uploads/2013/03/IPL-2009.jpg?fit=500%2C366&ssl=1"),
            WinnerModel("Rajasthan Royal Won","BY : Chennai Super Kings ","2008 ","https://staticg.sportskeeda.com/wp-content/uploads/2016/04/royals-1460374321-800.jpg")

        )

if (admob==true){
    val adapter = WinnerAdapter(items, this,false)
    val admobNativeAdAdapter = AdmobNativeAdAdapter.Builder.with(
        this.resources.getString(R.string.native_id),
        adapter,
        "medium"   // "medium" it can also used
    ).adItemInterval(4).build()
    binding.rvwinner.layoutManager = LinearLayoutManager(this)

    binding.rvwinner.adapter = admobNativeAdAdapter
}else if (fbads==true){
    var adapter = WinnerAdapter(items, this,fbads)
    binding.rvwinner.layoutManager = LinearLayoutManager(this)
    binding.rvwinner.adapter = adapter
}

        binding.ivbtnback.setOnClickListener { finish() }

    }
}