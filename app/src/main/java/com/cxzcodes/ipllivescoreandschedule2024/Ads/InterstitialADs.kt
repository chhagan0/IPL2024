package com.cxzcodes.ipllivescoreandschedule2024.Ads

import android.app.Activity
import android.app.ProgressDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import com.cxzcodes.ipllivescoreandschedule2024.R
import com.google.android.gms.ads.AdError
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.FullScreenContentCallback
import com.google.android.gms.ads.LoadAdError
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

object InterstitialADs {
    private var progress: ProgressDialog? = null
    var adRequest = AdRequest.Builder().build()
    private var isInterstitialLoaded = false

    private var mInterstitialAd: InterstitialAd? = null
    fun loadInter(context: Context) {
        InterstitialAd.load(
            context,
           "ca-app-pub-3940256099942544/1033173712",
            adRequest,
            object : InterstitialAdLoadCallback() {
                override fun onAdFailedToLoad(adError: LoadAdError) {
                    adError?.toString()?.let { Log.d("CHAGAN", it) }
                    mInterstitialAd = null
                    if (!isInterstitialLoaded) {
                        InterstitialADs.loadInter(context)
                        isInterstitialLoaded = true
                    }                }

                override fun onAdLoaded(interstitialAd: InterstitialAd) {
                    Log.d("CHAGAN", "Ad was loaded.")
                    mInterstitialAd = interstitialAd

                    progressHide()

                }
            })

    }

    fun showInter(context: Context, intent: Intent) {
        if (mInterstitialAd != null) {
            progressShow(context)
            mInterstitialAd?.show(context as Activity)
            mInterstitialAd?.fullScreenContentCallback = object : FullScreenContentCallback() {
                override fun onAdClicked() {
                    // Called when a click is recorded for an ad.
                    Log.d("CHAGAN", "Ad was clicked.")
                }

                override fun onAdDismissedFullScreenContent() {
                    Log.d("CHAGAN", "Ad dismissed fullscreen content.")
                    mInterstitialAd = null
                    if (!isInterstitialLoaded) {
                        InterstitialADs.loadInter(context)
                        isInterstitialLoaded = true
                    }
                    context.startActivity(intent)
                    progressHide()
                }

                override fun onAdFailedToShowFullScreenContent(p0: AdError) {
                    // Called when ad fails to show.
                    Log.e("CHAGAN", "Ad failed to show fullscreen content.")
                    mInterstitialAd = null
                }

                override fun onAdImpression() {
                    // Called when an impression is recorded for an ad.
                    Log.d("CHAGAN", "Ad recorded an impression.")
                }

                override fun onAdShowedFullScreenContent() {
                    // Called when ad is shown.
                    Log.d("CHAGAN", "Ad showed fullscreen content.")
                }
            }
        } else {
//            progressShow(context)
//            InterstitialAd.load(
//                context,
//                "ca-app-pub-3940256099942544/1033173712",
//                adRequest,
//                object : InterstitialAdLoadCallback() {
//                    override fun onAdFailedToLoad(adError: LoadAdError) {
//                        adError?.toString()?.let { Log.d("CHAGAN", it) }
//                        mInterstitialAd = null
//                        showInter(context, intent)
//                    }
//
//                    override fun onAdLoaded(interstitialAd: InterstitialAd) {
//                        Log.d("CHAGAN", "Ad was loaded.")
//                        mInterstitialAd = interstitialAd
//                        showInter(context, intent)
//                        progressHide()
//
//                    }
//                })
             context.startActivity(intent)
//            loadInter(context)
            Log.d("CHAGAN", "The interstitial ad wasn't ready yet.")
        }
    }

    fun progressShow(context: Context) {
        progress = ProgressDialog(context)
        progress?.setCancelable(false)
        progress?.setMessage("ADs Loading...")
        progress?.show()
    }

    fun progressHide() {
        if (progress != null) {
            progress?.dismiss()
        }
    }

}