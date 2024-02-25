package com.cxzcodes.ipllivescoreandschedule2024.Ads.FBADs

import android.content.Context
import android.content.Intent
import android.util.Log
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.InterstitialAd
import com.facebook.ads.InterstitialAdListener

object FbInterstitialADs {
    private val TAG: String = "CHAGAN"

    fun FbInter(context: Context,intent: Intent){
        val interstitialAd = InterstitialAd(context, "YOUR_PLACEMENT_ID")

// Create listeners for the Interstitial Ad
        val interstitialAdListener = object : InterstitialAdListener {
            override fun onInterstitialDisplayed(ad: Ad) {
                // Interstitial ad displayed callback
                Log.e(TAG, "Interstitial ad displayed.")
            }

            override fun onInterstitialDismissed(ad: Ad) {
                // Interstitial dismissed callback
                Log.e(TAG, "Interstitial ad dismissed.")
                context.startActivity(intent)
            }

            override fun onError(ad: Ad, adError: AdError) {
                // Ad error callback
                Log.e(TAG, "Interstitial ad failed to load: ${adError.errorMessage}")
                context.startActivity(intent)

            }

            override fun onAdLoaded(ad: Ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!")
                // Show the ad
                interstitialAd.show()
            }

            override fun onAdClicked(ad: Ad) {
                // Ad clicked callback
                Log.d(TAG, "Interstitial ad clicked!")
            }

            override fun onLoggingImpression(ad: Ad) {
                // Ad impression logged callback
                Log.d(TAG, "Interstitial ad impression logged!")
            }
        }

// For auto play video ads, it's recommended to load the ad
// at least 30 seconds before it is shown
        interstitialAd.loadAd(
            interstitialAd.buildLoadAdConfig()
                .withAdListener(interstitialAdListener)
                .build()
        )

    }
}