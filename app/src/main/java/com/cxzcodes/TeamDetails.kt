package com.cxzcodes

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cxzcodes.ipllivescoreandschedule2024.R
import com.cxzcodes.ipllivescoreandschedule2024.adapter.ItemAdapter
import com.cxzcodes.ipllivescoreandschedule2024.adapter.TeamAdapter
import com.cxzcodes.ipllivescoreandschedule2024.databinding.ActivityTeamDetailsBinding
import com.cxzcodes.ipllivescoreandschedule2024.model.ModelClass
import com.cxzcodes.ipllivescoreandschedule2024.model.TeamModel
import com.google.android.ads.nativetemplates.rvadapter.AdmobNativeAdAdapter

class TeamDetails : AppCompatActivity() {
    lateinit var binding: ActivityTeamDetailsBinding
    var items: List<TeamModel> = listOf()
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTeamDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val admob = sharedPreferences.getBoolean("ADMOB", true)
        val fbads = sharedPreferences.getBoolean("FBADS", true)
        val teamname = intent.getStringExtra("name")

        binding.ivbtnback.setOnClickListener { finish() }
        if (teamname == "CSK") {
            binding.tvteamname.setText("CSK")
            binding.tvcaptain.setText("MS Dhoni")
            binding.ivteamlogo.setImageResource(R.drawable.csk)
            items = listOf(
                TeamModel(
                    "MS Dhoni",
                    "https://parimatchnews.com/wp-content/uploads/2020/11/MS-Dohni.png",
                    "59",
                    "4876",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Devon Conway",
                    "https://scores.iplt20.com/ipl/playerimages/Devon%20Conway.png",
                    "50.62",
                    "1450",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Rituraj Gaikwad",
                    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhil3o2ZxEDKXAAyqvLjj5ejxTCyPzJI1jGSebJ7pVniZ4GiG621nreQdyV2yg1s7MuWWFvcOuBBczWrlDBGQV9dlgKEaosAjF_PST6a8Y_7hBc5WE5LKraVrPweAYDVsU2A830LU_CfdWT1ZGlI8sjQ-CyT0ZpVjYvX_74VPhzumawhIdNuwcmQ5qo3Q/s1024/102.png",
                    "73.25",
                    "1797",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Ambati Rayudu",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/60.png",
                    "79.05",
                    "4348",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Subhranshu Senapati",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/971.png",
                    "35.83",
                    "2437",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Moeen Ali",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/745.png",
                    "28.13 ",
                    "3094 ",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Shivam Dube",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/5431.png",
                    "140.22",
                    "2000",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Rajvardhan Hangargekar",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/783.png",
                    "139.12",
                    "2019",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Dwaine Pretorius",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/289.png",
                    "25.66",
                    "1989",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Mitchell Santner",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/75.png",
                    "25.06",
                    "802",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Ravindra Jadeja",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/9.png",
                    "32.70",
                    "2727",
                    R.drawable.allrounder,
                    "All Arounder"
                ),
                TeamModel(
                    "Tushar Deshpande ",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/3257.png",
                    "10.2",
                    "501",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Mukesh Chowdhary ",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/20575.png",
                    "9.32",
                    "1618",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Matheesha Pathirana",
                    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEi4cEip0SRJ1xGkQ40HcX7na-CvGnTkrP_leQ_mmWymryQXQdOWvdgaxuBL4wYzpTMkaNSL6QyFDfmzGw697-rM6tZIP09zACkcq0aiWQrP1nZZLWDMXZIaaWiGa9xLDoFF50HpW9tdIGAIbVdJovjubBKXYbHL4Y_ExLalXdBaYY3EHNfjwzgWF4f1/s1024/Matheesha-Pathirana.png",
                    "25.44",
                    "1918",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Simarjeet Singh",
                    "https://images.indiafantasy.com/wp-content/uploads/20220501191057/Simarjeet-Singh-IPL-2022-1.png",
                    "52.72",
                    "2309",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Deepak Chahar",
                    "https://i.cdn.newsbytesapp.com/sports/players/profile/deepak-chahar.png",
                    "33.84",
                    "1790",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Prashant Solanki ",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/972.png",
                    "6.33",
                    "713",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Maheesh Theekshana",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/20570.png",
                    "3.09",
                    "38",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Ajinkya Rahane",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/44.png",
                    "38.46",
                    "5077",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Ben Stokes",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/177.png",
                    "8.36",
                    "9836",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Shaik Rasheed",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/778.png",
                    "52",
                    "2509",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Nishant Sindhu",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/783.png",
                    "32.80",
                    "572",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Kyle Jamieson",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/382.png",
                    "19.27",
                    "424",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Ajay Mandal",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1931.png",
                    "121.51",
                    "402",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Bhagath Varma",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/577.png",
                    "5.67",
                    "922",
                    R.drawable.allrounder,
                    "All Rounder"
                ),


                )


        } else if (teamname == "MI") {
            binding.tvteamname.setText("MI")
            binding.tvcaptain.setText("Hardik Pandya")
            binding.ivteamlogo.setImageResource(R.drawable.mi)
            items = listOf(
                TeamModel(
                    "Rohit Sharma (c)",
                    "https://cricket.upcomingwiki.com/public/images/gallery/26551.png",
                    "43.57",
                    "18040",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Jasprit Bumrah",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/1124.png",
                    "23.31",
                    "474",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Suryakumar Yadav",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/108.png",
                    "48.46",
                    "733",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Ishan Kishan",
                    "https://parimatchnews.com/wp-content/uploads/2020/11/Ishan-Kishan.png",
                    "102.46",
                    "886",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Dewald Brevis",
                    "https://th.bing.com/th/id/R.f38f7624bede0629da99c703a049e861?rik=xycO8lT37v3sqQ&riu=http%3a%2f%2fcricketerdhoni.com%2fwp-content%2fuploads%2f2023%2f02%2f123-12.png&ehk=Nv9xtIB6WNRtwkeThOACicZf7J90B6Gbrkcy56X3iLQ%3d&risl=&pid=ImgRaw&r=0",
                    "24.5", "1078", R.drawable.batsman, "Batsman"
                ),
                TeamModel(
                    "Tilak Varma",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1015.png",
                    "52.36",
                    "746",
                    R.drawable.baller,
                    "Bowler"

                ),
                TeamModel(
                    "Jofra Archer",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/181.png",
                    "9.20",
                    "420",
                    R.drawable.baller,
                    "Bowler"


                ),
                TeamModel(
                    "Tim David",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/636.png",
                    "31.04",
                    "3832",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Mohd Arshad Khan",
                    "https://th.bing.com/th/id/R.4ab6329e98ad5aa9116e943d1f4a6f04?rik=04Du1QXl5LBbYg&riu=http%3a%2f%2fcricketerdhoni.com%2fwp-content%2fuploads%2f2023%2f02%2f123-18.png&ehk=yTPniWYTz5CkQ1YeEHrOMsI3qY0P%2bLioON5n7KDUoZY%3d&risl=&pid=ImgRaw&r=0",
                    "28.33", "2006", R.drawable.batsman, "Batsman"
                ),
                TeamModel(
                    "Ramandeep Singh",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/991.png",
                    "30.53",
                    "1555",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Hrithik Shokeen ",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/992.png",
                    "8.33", "100", R.drawable.baller, "Bowler"
                ),
                TeamModel(
                    "Arjun Tendulkar ",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/585.png",
                    "19.50", "950", R.drawable.allrounder, "All Rounder"
                ),
                TeamModel(
                    "Tristan Stubbs",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1017.png",
                    "6.00", "520", R.drawable.wicket, "Keeper"
                ),
                TeamModel(
                    "Kumar Kartikeya",
                    "https://www.mumbaiindians.com/static-assets/images/players/large/70191.png?v=3.75&w=200",
                    "9", "430", R.drawable.baller, "Bowler"
                ),
                TeamModel(
                    "Jason Behrendorff",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/4.png",
                    "21.26", "645", R.drawable.baller, "Bowler"
                ),
                TeamModel(
                    "Akash Madhwal",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/2975.png",
                    "4.80", "45", R.drawable.batsman, "Batsman"
                ),
                TeamModel(
                    "Cameron Green ",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/550.png",
                    "33.59", "1075", R.drawable.allrounder, "All Rounder"
                ),
                TeamModel(
                    "Jhye Richardson",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/59.png",
                    "13",
                    "366",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Piyush Chawla",
                    "https://www.mumbaiindians.com/static-assets/images/players/large/3729.png?v=1.34&w=400",
                    "2.73",
                    "243",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Duan Jansen",
                    "https://www.mumbaiindians.com/static-assets/images/players/large/70815.png?v=3.75&w=200",
                    "8.58", "1317", R.drawable.baller, "Bowler"
                ),
                TeamModel(
                    "Vishnu Vinod",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/581.png",
                    "40.05", "3218", R.drawable.wicket, "Keeper"
                ),
                TeamModel(
                    "Shams Mulani",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/600.png",
                    "33.89",
                    "1288",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Nehal Wadhera",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1541.png",
                    "4.87", "722", R.drawable.batsman, "Batsman"
                ),
                TeamModel(
                    "Raghav Goyal",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1933.png",
                    "8.25",
                    "1899",
                    R.drawable.batsman,
                    "Batsman"
                )
            )

        } else if (teamname == "KKR") {
            binding.tvteamname.setText("KKR")
            binding.tvcaptain.setText("Shreyash lyer")
            binding.ivteamlogo.setImageResource(R.drawable.kkr)
            items = listOf(
                TeamModel(
                    "Shreyas Iyer (c)",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/1563.png",
                    "05.42",
                    "4036",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Nitish Rana",
                    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiV1ARtg00DqfdcsN2cevhlIkyjHtTSziTUtPiponNwLw9ciynfy9FNBYj2soEGGqgS7JiDXc_jCysz3kxZjZ6hIb8mgSnt5bD7ue0caRXR-q1To__ei2Ie6G88_wZ4IK4F_Bb7mssRUkDsSOE8BeMZczYH842dWzaNwRL_PvMpXKOrIsMmeifo3mtF/s1024/Nitish-Rana.png",
                    "28.51", "2594", R.drawable.batsman, "Batsman"
                ),
                TeamModel(
                    "Venkatesh Iyer",
                    "https://th.bing.com/th/id/R.ded1c8bf15f5c8a64384ec9e8fa59f29?rik=4yuszkudnYrPnQ&riu=http%3a%2f%2fipluniverse.com%2fwp-content%2fuploads%2f2023%2f05%2fVenkatesh-Iyer.png&ehk=J51ZFXqW%2fNZQKkOSrOeNrfgK00LGAz%2bkrPdmJVFrDZs%3d&risl=&pid=ImgRaw&r=0",
                    "7.81",
                    "956",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Andre Russell",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/141.png",
                    "130.22",
                    "1170",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Sunil Narine",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/203.png",
                    "23.31",
                    "892",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Umesh Yadav ",
                    "https://www.kkr.in/static-assets/images/players/2020/5221.png?v=4.4&w=150",
                    "10.56",
                    "413",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Tim Southee",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/307.png",
                    "16.21",
                    "2011",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Harshit Rana",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1013.png",
                    "1.0",
                    "233",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Varun Chakravarthy",
                    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEh1e9dKvoWEvOUYpWqxXObh2FqfQjh91bP19t6b5acI47-FoFrv_07Zi4d-tpGOZT96XixKlw3MUL3hZHQnfM6Fdi7j5rqprYuwl2qi5CpQ2wkCAeG1iNbBKUlJFviW4EvHkq31XMklh-m403Ku8KX8k3chzX1MIZYoZSQOaRoSCjPcpzQfuaj_9iHj/s600/Varun-Chakaravarthy.png",
                    "14.7",
                    "733",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Anukul Roy",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/3774.png",
                    "34.37",
                    "748",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Rinku Singh",
                    "https://www.kkr.in/static-assets/images/players/2020/64727.png?v=2&w=200",
                    "142.16",
                    "725",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Rahmanullah Gurbaz",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/641.png",
                    "25.68",
                    "1207",
                    R.drawable.wicket,
                    "Keeper"
                ),
                TeamModel(
                    "Shardul Thakur",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/105.png",
                    "20.21",
                    "124",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Lockie Ferguson",
                    "https://im.indiatimes.in/content/2020/Sep/Lockie-Ferguson_5f6c6ed1d1924.png",
                    "11.11",
                    "792",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "N Jagadeesan",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/97.png",
                    "114.4",
                    "799",
                    R.drawable.wicket,
                    "Keeper"
                ),
                TeamModel(
                    "Vaibhav Arora",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/583.png",
                    "9.16",
                    "265",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Suyash Sharma",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1932.png",
                    "8.71",
                    "330",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "David Wiese",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/674.png",
                    "29.06",
                    "5814",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Kulwant Khejroliya",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/204.png",
                    "124",
                    "5834",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Litton Das",
                    "https://www.kkr.in/static-assets/images/players/2020/63206.png?v=5.11&w=200",
                    "25.03",
                    "2563",
                    R.drawable.wicket,
                    "Keeper"
                ),
                TeamModel(
                    "Mandeep Singh",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/132.png",
                    "93",
                    "6260",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Shakib Al Hasan",
                    "https://www.kkr.in/static-assets/images/players/2020/3782.png?v=4.4&w=200",
                    "122.47",
                    "7570",
                    R.drawable.allrounder,
                    "All Rounder"
                ),

                )

        } else if (teamname == "SRH") {
            binding.tvteamname.setText("SRH")
            binding.tvcaptain.setText("Aiden Markram")
            binding.ivteamlogo.setImageResource(R.drawable.srh)
            items = listOf(
                TeamModel(
                    "Aiden Markram (c)",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/287.png",
                    "182",
                    "2933",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Abdul Samad",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/525.png",
                    "8.25",
                    "395",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Umran Malik",
                    "https://www.loksatta.com/wp-content/uploads/2022/05/cropped-umran-malik-1.webp",
                    "30.29",
                    "1402",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Washington Sundar",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/20.png",
                    "66.25",
                    "265",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Rahul Tripathi",
                    "https://static.indiatvnews.com/ins-web/events/ipl-2022/srh/rahul-tripathi.png",
                    "19.40",
                    "3301",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Abhishek Sharma ",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/3760.png",
                    "29.55",
                    "2987",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Kartik Tyagi",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/212.png",
                    "7.0",
                    "285",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "T Natarajan",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/224.png",
                    "3.10",
                    "299",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Bhuvneshwar Kumar",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/116.png",
                    "18.22",
                    "540",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Marco Jansen",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/586.png",
                    "20.15",
                    "803",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Glenn Phillips",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/635.png",
                    "35.00",
                    "335",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Fazalhaq Farooqi",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1011.png",
                    "7.07",
                    "14",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Harry Brook ",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1218.png",
                    "89.88",
                    "809",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Mayank Agarwal",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/55.png",
                    "86",
                    "1488",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Heinrich Klaasen",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/202.png",
                    "17.2",
                    "1488",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Adil Rashid",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/311.png",
                    "39.83",
                    "2091",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Mayank Makanrde",
                    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEiZKvh5lt3a-hj2sEdz-lHqf50bhODF7BZbuAwpJKKSFgWXTkexXYPnHZ6TFKi4LRWiKDJmQKm_AexNLMpShHsC7Q4nJGm8WWqctD8K-DVgh1oMlc-9cEXtKZUpBupjnCAEVbyW2A62z60X7fxBvnqMDixFAKM0I6MtRAKtxbUj986-WufQqX-95gtp/s600/Mayank-Markande.png",
                    "23.57",
                    "1255",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Vivrant Sharma",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1942.png",
                    "69",
                    "1468",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Samarth Vyas",
                    "https://sunrisershyderabad.in/uploads/image/SRH-6426b62d767656.52157504vtczj071.png",
                    "47.43",
                    "1040",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Sanvir Singh",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1943.png",
                    "37.00",
                    "740",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Upendra Singh Yadav",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1472.png",
                    "42.46",
                    "1741",
                    R.drawable.wicket,
                    "Keeper"
                ),
                TeamModel(
                    "Mayank Dagar",
                    "https://admin.matchtimings.com/assets/player/ee5aabec1b8d4b2f7a67062b76bc7798.png",
                    "17.70",
                    "140",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Nitish Kumar Reddy",
                    "https://sunrisershyderabad.in/uploads/image/SRH-6426b67abd81a8.19998229zm7pf)je.png",
                    "35.08",
                    "421",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Akeal Hosein",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/722.png",
                    "14.15",
                    "283",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Anmolpreet Singh",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/159.png",
                    "44.83",
                    "2197",
                    R.drawable.batsman,
                    "Batsman"
                ),
            )

        } else if (teamname == "RR") {
            binding.tvteamname.setText("RR")
            binding.tvcaptain.setText("Sanju Samon")
            binding.ivteamlogo.setImageResource(R.drawable.rr)
            items = listOf(
                TeamModel(
                    "Sanju Samson (c)",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/258.png",
                    "55.71",
                    "390",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Jos Buttler",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/509.png",
                    "34.84",
                    "2932",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Yashasvi Jaiswal",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/533.png",
                    "35.70",
                    "2318",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "R. Ashwin",
                    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEhzYfqUhsF6g0K9ZU9ztatzXSGZ_iP_y9PXv3JnIeXGsoOGYd62x3i67HDXP5LbX28YIDTe27WYNAOI51NJuM6IYS9x-sRO5HHbi_nbSaP3jVtr2G_iHV2xn2jSJFygWJ0S0Czl6gH1RHApCYctf-ZEuD2_qOmQXRpzxSjz4d4LwitG5ywqH8gphnuY/s1024/45.png",
                    "23.59",
                    "11610",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Trent Boult",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/969.png",
                    "12.14",
                    "986",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Shimron Hetmyer",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/210.png",
                    "32.23",
                    "1515",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Devdutt Padikkal",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/200.png",
                    "23.72",
                    "261",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Riyan Parag",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/189.png",
                    "16.22",
                    "600",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "KC Cariappa",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/2743.png",
                    "8.00",
                    "348",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Prasidh Krishna",
                    "https://www.rajasthanroyals.com/static-assets/images/players/65702.png?v=5.48",
                    "65.00",
                    "130",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Yuzvendra Chahal",
                    "https://hashmiabdulmajid.github.io/tataipl2022.github.io/chahal.png",
                    "27.13",
                    "3214",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Navdeep Saini",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/207.png",
                    "43.00",
                    "172",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Obed McCoy ",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/645.png",
                    "7.78",
                    "109",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Kuldeep Sen",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/593.png",
                    "7.40",
                    "37",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Dhruv Jurel",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1004.png",
                    "56.63",
                    "790",
                    R.drawable.wicket,
                    "Keeper"
                ),
                TeamModel(
                    "Kuldip Yadav",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/593.png",
                    "21.55",
                    "733",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Jason Holder",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/263.png",
                    "25.74",
                    "2440",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Donovan Ferreira",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/2033.png",
                    "30.00",
                    "60",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Kunal Rathore",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1540.png",
                    "22.14",
                    "202",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Adam Zampa",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/24.png",
                    "28.12",
                    "4614",
                    R.drawable.baller,
                    "Baller"
                ),
                TeamModel(
                    "KM Asif",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/88.png",
                    "24.22",
                    "969",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Murugan Ashwin",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/135.png",
                    "26.01",
                    "2163",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Akash Vashisht",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1938.png",
                    "38.41",
                    "1306",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Abdul PA",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1542.png",
                    "19.36",
                    "758",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Joe Root",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/312.png",
                    "50.29",
                    "11416",
                    R.drawable.batsman,
                    "Batsman"
                ),
            )


        } else if (teamname == "RCB") {
            binding.tvteamname.setText("RCB")
            binding.tvcaptain.setText("Faf Du Plessis ")

            binding.ivteamlogo.setImageResource(R.drawable.rcb)
            items = listOf(
                TeamModel(
                    "Faf Du Plessis (c)",
                    "https://th.bing.com/th/id/OIP.bQweossfcTXV72lwgySxUQAAAA?rs=1&pid=ImgDetMain",
                    "40.02",
                    "4164",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Virat Kohli",
                    "https://th.bing.com/th/id/R.2de0d4bcfdfce96788c70217733cad37?rik=KPGyzABdLUILpQ&riu=http%3a%2f%2fipluniverse.com%2fwp-content%2fuploads%2f2023%2f05%2fVirat-Kohli.png&ehk=g6wVQSSJpOVz%2bqyfvS%2f4ImFExlBmA2geiABMzZpQ%2bjo%3d&risl=&pid=ImgRaw&r=0",
                    "55.56", "8846", R.drawable.batsman, "Batsman"
                ),
                TeamModel(
                    "Glenn Maxwell",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/28.png",
                    "26.07",
                    "339",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Mohammad Siraj",
                    "https://blogger.googleusercontent.com/img/b/R29vZ2xl/AVvXsEj9XwV3wwcCzVlJODtW9YPG596zLZoz7qXvdNfwjj9RLQ1iSuONeOuIr3YlFNAvmzHD-NP5z9iWO-pLBQt8vUsgk0xksX7vrC856aGCWyxiioqGGzEYPkRPCeS1aQnWfXJp_gjsusBXD7r4gZCP65uLLu2o_eKuuLYsXCT9oliniVh9aN9C8XwJ-cYNYw/s1024/siraj.png",
                    "28.25", "1921", R.drawable.baller, "Bowler"
                ),
                TeamModel(
                    "Harshal Patel ",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/114.png",
                    "23.69",
                    "5498",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Wanindu Hasaranga",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/377.png",
                    "28.00",
                    "196",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Dinesh Karthik",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/13.png",
                    "25.00",
                    "1025",
                    R.drawable.wicket,
                    "Keeper"

                ),
                TeamModel(
                    "Shahbaz Ahemad",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/523.png",
                    "0.13",
                    "1",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Rajat Patidar",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/playerheadshot/ipl/284/5471.png",
                    "22.00",
                    "22",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Anuj Rawat ",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/534.png",
                    "37.00",
                    "74",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Akash Deep",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1007.png",
                    "19.36",
                    "536",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Josh Hazlewood",
                    "https://static.indiatvnews.com/ins-web/events/ipl-2022/rcb/josh-hazlewood.png",
                    "39.00",
                    "465",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Mahipal Lomror",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/2970.png",
                    "29.85",
                    "209",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Finn Allen",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/595.png",
                    "27.71",
                    "582",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Suyash Prabhudessai",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/playerheadshot/ipl/284/7002.png",
                    "44.04",
                    "1057",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Karn Sharma",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/98.png",
                    "59.50",
                    "238",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Siddharth Kaul",
                    "https://storage.googleapis.com/cricketimages/Players/9T.png",
                    "6.62",
                    "376",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "David Willey ",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2022/2758.png",
                    "29.75",
                    "2975",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Reece Topley",
                    "https://th.bing.com/th/id/OIP.YhbWtSm3AHpn_vEkJq32MgAAAA?rs=1&pid=ImgDetMain",
                    "26.13",
                    "1202",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Himanshu Sharma",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/98.png",
                    "9.33",
                    "288",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Will Jacks",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/98.png",
                    "3.72",
                    "1234",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Manoj Bhandage",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1485.png",
                    "21.57",
                    "151",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Rajan Kumar",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1503.png",
                    "15.27",
                    "11",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Avinash Singh",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1939.png",
                    "29.36",
                    "369",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Sonu Yadav",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1940.png",
                    "16.00",
                    "351",
                    R.drawable.batsman,
                    "Batsman"
                ),

                )

        } else if (teamname == "DC") {
            binding.tvteamname.setText("DC")
            binding.tvcaptain.setText("Rishabh Pant/ David Warner ")
            binding.ivteamlogo.setImageResource(R.drawable.dc)
            items = listOf(
                TeamModel(
                    "David Warner",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/214.png",
                    "44.59",
                    "8786",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Axar Patel",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/110.png",
                    "17.16",
                    "585",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Prithvi Shaw",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/51.png",
                    "18.81",
                    "489",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Anrich Nortje",
                    "https://parimatchnews.com/wp-content/uploads/2020/11/Anriche-Nortje.png",
                    "26.71",
                    "1870",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Mitchell Marsh",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/40.png",
                    "33.98",
                    "1859",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Sarfaraz Khan",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/139.png",
                    "51.42",
                    "1080",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Kamlesh Nagarkoti",
                    "https://cdn.iplbetonline.in/wp-content/uploads/2023/04/3766-780x780.png",
                    "15.14",
                    "212",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Mustafizur Rahman",
                    "https://iplwiki.com/wp-content/uploads/2023/12/Mustafizur-Rahman.png",
                    "36.74",
                    "1139",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Kuldeep Yadav",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/14.png",
                    "21.55",
                    "733",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Khaleel Ahmed",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/8.png",
                    "31.00",
                    "465",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Chetan Sakariya",
                    "https://e8h4f7q7.rocketcdn.me/wp-content/uploads/2021/06/Chetan-Sakariya-1.jpg",
                    "17.00",
                    "34",
                    R.drawable.baller,
                    "Bowler"
                ), //not png
                TeamModel(
                    "Lalit Yadav",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/538.png",
                    "38.04",
                    "951",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Ripal Patel",
                    "https://cdn.iplbetonline.in/wp-content/uploads/2023/04/17191.png",
                    "27.00",
                    "108",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Yash Dhull",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/777.png",
                    "46.83",
                    "281",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Rovman Powell",
                    "https://www.rajasthanroyals.com/static-assets/images/players/65291.png?v=5.79",
                    "21.75",
                    "959",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Pravin Dubey",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/548.png",
                    "40.00",
                    "80",
                    R.drawable.baller,
                    "Batsman"
                ),
                TeamModel(
                    "Lungi Ngidi",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/99.png",
                    "22.62",
                    "1222",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Vicky Ostwal",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/786.png",
                    "62.00",
                    "558",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Aman Khan",
                    "https://mlmftt9lz1qy.i.optimole.com/w:500/h:500/q:mauto/f:avif/https://spkfacts.com/wp-content/uploads/2023/04/Aman-Khan.jpg",
                    "8.00", "32", R.drawable.batsman, "Batsman"
                ), //not png
                TeamModel(
                    "Phil Salt",
                    "https://cf-images.eu-west-1.prod.boltdns.net/v1/static/3588749423001/736a866f-ebc8-42cf-a0b2-98cb91c0c22e/193f1ca9-9ae3-44c1-bbd5-9decbac65bef/1280x720/match/image.jpg",
                    "36.41", "619", R.drawable.batsman, "Batsman"
                ), //not png
                TeamModel(
                    "Ishant Sharma",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/50.png",
                    "32.40",
                    "10078",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Mukesh Kumar",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1462.png",
                    "18.16",
                    "109",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Manish Pandey",
                    "https://www.sakshi.com/sites/default/files/special/ipl/2022/teams/dc/ManishPandey.png",
                    "33.29",
                    "566",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Rilee Rossouw",
                    "https://i0.wp.com/iansportalimages.s3.amazonaws.com/thumbnails/eee163fe49ba59f0e6654f12dd9de748.jpg?w=696&ssl=1",
                    "38.71",
                    "1239",
                    R.drawable.batsman,
                    "Batsman"
                )
            )//not png

        } else if (teamname == "PBKS") {
            binding.tvteamname.setText("PBKS")
            binding.tvcaptain.setText("Sikhar Dhawan ")
            binding.ivteamlogo.setImageResource(R.drawable.pbks)
            items = listOf(
                TeamModel(
                    "Shikar Dhawan",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/11.png",
                    "40.61",
                    "2315",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Arshdeep Singh",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/125.png",
                    "18.40",
                    "184",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Kagiso Rabada",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/116.png",
                    "22.05",
                    "6419",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Jonny Bairstow",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/216.png",
                    "31.36",
                    "345",
                    R.drawable.wicket,
                    "Keeper"
                ),
                TeamModel(
                    "Shahrukh Khan",
                    "https://www.punjabkingsipl.in/static-assets/images/players/64721.png?v=5.6",
                    "20.29",
                    "426",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Harpreet Brar",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/130.png",
                    "17.56",
                    "158",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Prabhsimran Singh",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/137.png",
                    "41.00",
                    "82",
                    R.drawable.wicket,
                    "Keeper"
                ),
                TeamModel(
                    "Jitesh Sharma",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1000.png",
                    "14.28",
                    "100",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Rahul Chahar",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/171.png",
                    "18.00",
                    "54",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Laim Livingstone",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/183.png",
                    "16.00",
                    "16",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Raj Bawa",
                    "https://www.punjabkingsipl.in/static-assets/images/players/89168.png?v=5.86",
                    "57.16",
                    "343",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Rishi Dhawan",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/996.png",
                    "12.00",
                    "12",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Baltej Dhanda",
                    "https://cdn.iplbetonline.in/wp-content/uploads/2023/04/994.png",
                    "7.75",
                    "79",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Nathan Ellis",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/633.png",
                    "38.20",
                    "382",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Atharva Taide",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1001.png",
                    "145",
                    "290",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Bhanuka Rajapaksa",
                    "https://www.punjabkingsipl.in/static-assets/images/players/10183.png?v=5.6",
                    "17.80",
                    "89",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Sam Curran",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/138.png",
                    "24.69",
                    "815",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Sikandar Raza",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/820.png",
                    "35.96",
                    "1187",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Harpreet Bhatia",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1934.png",
                    "19.2",
                    "96",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Vidwath Kaverappa",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1564.png",
                    "20.74",
                    "1141",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Mohit Rathe",
                    "https://www.punjabkingsipl.in/static-assets/images/players/100577.png?v=5.6",
                    "17.25",
                    "138",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Shivam Singh",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1936.png",
                    "50.37",
                    "403",
                    R.drawable.baller,
                    "Bowler"
                )
            )


        } else if (teamname == "LSG") {
            binding.tvteamname.setText("LSG")
            binding.tvcaptain.setText("KL Rahul ")
            binding.ivteamlogo.setImageResource(R.drawable.lsg)
            items = listOf(
                TeamModel(
                    "KL Rahul",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/19.png",
                    "33.59",
                    "2755",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Marcus Stoinis",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/23.png",
                    "27.03",
                    "1487",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Ravi Bishnoi",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/520.png",
                    "69.00",
                    "69",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Quinton De Kock",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/170.png",
                    "38.82",
                    "3300",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Deepak Hooda",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/215.png",
                    "25.50",
                    "153",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Krunal Pandya",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/17.png",
                    "81.33",
                    "366",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Avesh Khan",
                    "https://cdn.iplbetonline.in/wp-content/uploads/2023/04/109.png",
                    "36.55",
                    "329",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Mark Wood",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/315.png",
                    "29.45",
                    "3063",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "K Gowtham",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/179.png",
                    "23.95",
                    "1916",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Manan Vohra",
                    "https://www.lucknowsupergiants.in/static-assets/images/players/60205.png?v=8.2",
                    "37.68",
                    "2902",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Mohsin Khan",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/541.png",
                    "37.10",
                    "2709",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Ayush Badoni",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/985.png",
                    "35.57",
                    "249",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Kyle Mayers",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/726.png",
                    "32.72",
                    "949",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Karan Sharma",
                    "https://www.lucknowsupergiants.in/static-assets/images/players/68315.png?v=8.2",
                    "23.05",
                    "438",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "c",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/987.png",
                    "23.00",
                    "46",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Nicholas Pooran",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/136.png",
                    "39.66",
                    "1938",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Jaydev Unadkat",
                    "https://www.lucknowsupergiants.in/static-assets/images/players/5448.png?v=8.2",
                    "77.00",
                    "231",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Yash Thakur",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/1550.png",
                    "26.40",
                    "1056",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Romrio Shepherd",
                    "https://cdn.iplbetonline.in/wp-content/uploads/2023/04/371.png",
                    "40.76",
                    "1019",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Daniel Sams",
                    "https://www.lucknowsupergiants.in/static-assets/images/players/67859.png?v=8.2",
                    "26.50",
                    "106",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Amit Mishra",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/107.png",
                    "35.72",
                    "2715",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Prerak Mankad",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/998.png",
                    "32.45",
                    "2207",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Swapnil Singh",
                    "https://www.lucknowsupergiants.in/static-assets/images/players/4602.png?v=8.2",
                    "31.08",
                    "5284",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Naveen ul Haq",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/639.png",
                    "32.18",
                    "708",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Yudhvir Charak",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/587.png",
                    "80.00",
                    "240",
                    R.drawable.baller,
                    "Bowlelr"
                )
            )

        } else {
            binding.tvteamname.setText("GT")
            binding.tvcaptain.setText("Shubman Gill ")
            binding.ivteamlogo.setImageResource(R.drawable.gt)
            items = listOf(
                TeamModel(
                    "Hardik Pandya",
                    "https://www.gujarattitansipl.com/static-assets/images/players/63751.png?v=4.51",
                    "31.29",
                    "532",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Shubman Gill",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/62.png",
                    "30.58", "1040", R.drawable.batsman, "Batsman"
                ),
                TeamModel(
                    "David Miller",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/128.png",
                    "42.05",
                    "44.58",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Abhinav Manohar",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/974.png",
                    "37.25",
                    "149",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Sai Sudharsan",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/976.png",
                    "63.50",
                    "127",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Wriddhhiman Saha",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/225.png",
                    "29.41",
                    "1353",
                    R.drawable.wicket,
                    "Keeper"
                ),
                TeamModel(
                    "Matthew Wade",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/549.png",
                    "29.87",
                    "1613",
                    R.drawable.wicket,
                    "Keeper"
                ),
                TeamModel(
                    "Rashid Khan",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/218.png",
                    "22.35",
                    "760",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Rahul Tewatia",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/120.png",
                    "22.96",
                    "574",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Vijay Shankar",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/61.png",
                    "31.85",
                    "223",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Mohammed Shami",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/47.png",
                    "27.71",
                    "6346",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Alzarri Joseph",
                    "https://www.gujarattitansipl.com/static-assets/images/players/64264.png?v=4.51",
                    "35.79",
                    "3078",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Yash Dayal",
                    "https://www.gujarattitansipl.com/static-assets/images/players/70155.png?v=4.51",
                    "29.72",
                    "1813",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Pradeep Sangwan",
                    "https://www.gujarattitansipl.com/static-assets/images/players/4280.png?v=4.51",
                    "30.43",
                    "5418",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Darshan Nalkande",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/127.png",
                    "49.50",
                    "297",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Jayant Yadav",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/165.png",
                    "29.06",
                    "465",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "R Sai Kishore",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/544.png",
                    "15.75",
                    "63",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Noor Ahmad",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/975.png",
                    "48.28",
                    "338",
                    R.drawable.wicket,
                    "Keeper"
                ),
                TeamModel(
                    "Kane Williamson",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/65.png",
                    "54.36",
                    "8263",
                    R.drawable.batsman,
                    "Batsman"
                ),
                TeamModel(
                    "Odean Smith",
                    "https://www.gujarattitansipl.com/static-assets/images/players/65285.png?v=4.51",
                    "26.10",
                    "261",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "KS Bharat",
                    "https://www.gujarattitansipl.com/static-assets/images/players/60173.png?v=4.51",
                    "18.43",
                    "129",
                    R.drawable.wicket,
                    "Keeper"
                ),
                TeamModel(
                    "Shivam Mavi",
                    "https://www.gujarattitansipl.com/static-assets/images/players/66984.png?v=4.51",
                    "17.57",
                    "123",
                    R.drawable.allrounder,
                    "All Rounder"
                ),
                TeamModel(
                    "Urvil Patel",
                    "https://cdn.iplbetonline.in/wp-content/uploads/2023/04/1486.png",
                    "77.77",
                    "63",
                    R.drawable.wicket,
                    "Keeper"
                ),
                TeamModel(
                    "Joshua Little",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/678.png",
                    "31.37",
                    "1757",
                    R.drawable.baller,
                    "Bowler"
                ),
                TeamModel(
                    "Mohit Sharma",
                    "https://bcciplayerimages.s3.ap-south-1.amazonaws.com/ipl/IPLHeadshot2023/100.png",
                    "32.90",
                    "1020",
                    R.drawable.batsman,
                    "Batsman"
                ),

                )
        }


        if (admob == true) {
            val adapter = TeamAdapter(items, this, false)
            val admobNativeAdAdapter = AdmobNativeAdAdapter.Builder.with(
                this.resources.getString(com.cxzcodes.ipllivescoreandschedule2024.R.string.native_id),
                adapter,
                "small"   // "medium" it can also used
            ).adItemInterval(4).build()
            binding.rvteamdetails.layoutManager = LinearLayoutManager(this)

            binding.rvteamdetails.adapter = admobNativeAdAdapter
        } else if (fbads == true) {
            var adapter = TeamAdapter(items, this, fbads)


            binding.rvteamdetails.layoutManager = LinearLayoutManager(this)
            binding.rvteamdetails.adapter = adapter
        }

    }

}