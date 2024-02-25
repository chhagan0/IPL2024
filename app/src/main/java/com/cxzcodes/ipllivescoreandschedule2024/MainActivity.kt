package com.cxzcodes.ipllivescoreandschedule2024

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.util.Log.d
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.bumptech.glide.Glide
import com.cxzcodes.ipllivescoreandschedule2024.Ads.BannerADs
import com.cxzcodes.ipllivescoreandschedule2024.Ads.FBADs.FbBannerADs
import com.cxzcodes.ipllivescoreandschedule2024.Ads.FBADs.FbInterstitialADs
import com.cxzcodes.ipllivescoreandschedule2024.Ads.InterstitialADs
import com.cxzcodes.ipllivescoreandschedule2024.Utils.Utils
import com.cxzcodes.ipllivescoreandschedule2024.databinding.ActivityMainBinding
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.google.android.material.tabs.TabLayout.Tab
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.getValue
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var mediaPlayer: MediaPlayer

    private lateinit var analytics: FirebaseAnalytics
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)
        analytics = Firebase.analytics
        analytics = FirebaseAnalytics.getInstance(this)
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        checkstatus()
        val admob = sharedPreferences.getBoolean("ADMOB", true)
        val fbads = sharedPreferences.getBoolean("FBADS", true)
        Utils.notification(this)
        InterstitialADs.loadInter(this)
        getdatafirebase()
        playMusic()
        setSupportActionBar(binding.toolbar)

        val imageList = ArrayList<SlideModel>()

        imageList.add(
            SlideModel(
                "https://mir-s3-cdn-cf.behance.net/project_modules/fs/05834e80113099.6210bd8ad5bf7.jpg",
                ScaleTypes.CENTER_CROP
            )
        )
        imageList.add(
            SlideModel(
                "https://th.bing.com/th/id/OIP.rfsK_w4sZ1lZi3eMnVhAlgAAAA?rs=1&pid=ImgDetMain",
                ScaleTypes.CENTER_CROP
            )
        )
        imageList.add(
            SlideModel(
                "https://india.cricketschedule.com/wp-content/uploads/sites/6/2021/02/ipl-india-768x384.jpg",
                ScaleTypes.CENTER_CROP
            )
        )
        imageList.add(
            SlideModel(
                "https://i.ytimg.com/vi/xPBCvh2CORM/maxresdefault.jpg",
                ScaleTypes.CENTER_CROP
            )
        )

        val imageSlider = findViewById<ImageSlider>(R.id.image_slider)
        imageSlider.setImageList(imageList)

        toggle = ActionBarDrawerToggle(this, binding.drawerlayout, R.string.open, R.string.close)
        binding.drawerlayout.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        toggle.syncState()



        binding.navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {

                R.id.home -> binding.drawerlayout.close()
                R.id.rateus -> Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show()
                R.id.website -> {
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://thetazatimes.com/"))
                    startActivity(intent)
                }

                R.id.privacy -> {
                    val intent = Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://sites.google.com/view/ipl-live-score-schedule/home")
                    )
                    startActivity(intent)
                }

                R.id.share -> {
                    val url =
                        "https://play.google.com/store/apps/details?id=com.cxzcodes.ipllivescoreandschedule2024"
                    val share = Intent(Intent.ACTION_SEND)
                    share.type = "text/plain"
                    share.putExtra(Intent.EXTRA_TEXT, "Check IPL live Score and Schedule: $url")
                    startActivity(Intent.createChooser(share, "Share via"))
                }


            }
            true
        }

        Glide.with(this).load(R.drawable.onlylive).into(binding.ivLive)

        binding.schedule.setOnClickListener {
            d("CHAGANF", "admob click: $admob")
            d("CHAGANF", "FbADs click: $fbads")
            val intent = Intent(this, ScheduleTeams::class.java)

            if (admob == true) {
                InterstitialADs.showInter(this, intent)

            } else if (fbads == true) {
                FbInterstitialADs.FbInter(this, intent)

            }

//            startActivity(
//                Intent(
//                    this,
//                    com.cxzcodes.ipllivescoreandschedule2024.ScheduleTeams::class.java
//                )
//            )
        }
        binding.cvteams.setOnClickListener {
            val intent = Intent(this, Teamsactivity::class.java)
            if (admob == true) {
                InterstitialADs.showInter(this, intent)

            } else if (fbads == true) {
                FbInterstitialADs.FbInter(this, intent)

            }//            startActivity(
//                Intent(
//                    this,
//                    Teamsactivity::class.java
//                )
//            )
        }
        binding.news.setOnClickListener {
            val intent = Intent(this, NewsActivity::class.java)
            if (admob == true) {
                InterstitialADs.showInter(this, intent)

            } else if (fbads == true) {
                FbInterstitialADs.FbInter(this, intent)

            }//            startActivity(
//                Intent(
//                    this,
//                    NewsActivity::class.java
//                )
//            )
        }
        binding.Venus.setOnClickListener {
            val intent = Intent(this, VenusActivity::class.java)
            if (admob == true) {
                InterstitialADs.showInter(this, intent)

            } else if (fbads == true) {
                FbInterstitialADs.FbInter(this, intent)

            }//            startActivity(
//                Intent(
//                    this,
//                    VenusActivity::class.java
//                )
//            )
        }
        binding.livescore.setOnClickListener {
            val intent = Intent(this, LiveScoreActivity::class.java)
//            InterstitialADs.showInter(this,intent)
            if (admob == true) {
                InterstitialADs.showInter(this, intent)

            } else if (fbads == true) {
                FbInterstitialADs.FbInter(this, intent)

            }//            startActivity(
//                Intent(
//                    this,
//                    LiveScoreActivity::class.java
//                )
//            )
        }
        binding.pointtable.setOnClickListener {
            val intent = Intent(this, TableActivity::class.java)
            if (admob == true) {
                InterstitialADs.showInter(this, intent)

            } else if (fbads == true) {
                FbInterstitialADs.FbInter(this, intent)

            }//            startActivity(
//                Intent(
//                    this,
//                    TableActivity::class.java
//                )
//            )
        }
        binding.cvwinner.setOnClickListener {
            val intent = Intent(this, WinnerActivity::class.java)
            if (admob == true) {
                InterstitialADs.showInter(this, intent)

            } else if (fbads == true) {
                FbInterstitialADs.FbInter(this, intent)

            }//            startActivity(
//                Intent(
//                    this,
//                    WinnerActivity::class.java
//                )
//            )
        }

    }

    private fun checkstatus() {
        val admob = sharedPreferences.getBoolean("ADMOB", true)
        val fbads = sharedPreferences.getBoolean("FBADS", true)
        d("CHAGANF", "admob: $admob")
        d("CHAGANF", "FbADs: $fbads")
        if (admob == true) {
            BannerADs.bannerADShow(this, binding.adView)
            BannerADs.bannerADShow(this, binding.adView2)
        } else if (fbads == true) {
            FbBannerADs.FbBannerads(this, binding.bannerContainer)
            FbBannerADs.FbBannerads(this, binding.bannerContainer2)

        }


    }

    private fun getdatafirebase() {
        val databaseReference: DatabaseReference = FirebaseDatabase.getInstance().reference

        val adsConfigReference: DatabaseReference = databaseReference.child("Value")

        adsConfigReference.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val admobAds: Boolean =
                        dataSnapshot.child("Admobads").getValue(Boolean::class.java) ?: false
                    val fbAds: Boolean =
                        dataSnapshot.child("Fbads").getValue(Boolean::class.java) ?: false

                    val editor = sharedPreferences.edit()
                    editor.putBoolean("ADMOB", admobAds)
                    editor.putBoolean("FBADS", fbAds)
                    editor.apply()
                    // Now you have the values of Admobads and Fbads
                    // Use these values as needed in your app
                    if (admobAds) {
                        // Admob ads are enabled
                    } else {
                        // Admob ads are disabled
                    }

                    if (fbAds) {
                        // Facebook ads are enabled
                    } else {
                        // Facebook ads are disabled
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle errors
            }
        })
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        toggle.syncState()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        toggle.onConfigurationChanged(newConfig)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            binding.drawerlayout.openDrawer(GravityCompat.START)

            true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun playMusic() {
        mediaPlayer = MediaPlayer.create(this, R.raw.iplnotification)
        mediaPlayer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.release()

    }
}