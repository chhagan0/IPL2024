package com.cxzcodes.ipllivescoreandschedule2024.Ads

import android.content.Context
import android.util.Log.d
import android.view.View
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.LoadAdError

object BannerADs {
    fun bannerADShow(context: Context, adView: AdView) {
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        adView.adListener = object : AdListener() {


            override fun onAdFailedToLoad(p0: LoadAdError) {
//                d("CHAGAN", "Banner Ad FAILED: ${p0.message}")
                adView.loadAd(adRequest)
            }


            override fun onAdLoaded() {
                adView.visibility = View.VISIBLE
            }


        }
    }
}