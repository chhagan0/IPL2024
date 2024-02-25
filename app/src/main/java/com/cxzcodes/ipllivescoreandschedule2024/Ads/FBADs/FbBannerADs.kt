package com.cxzcodes.ipllivescoreandschedule2024.Ads.FBADs

import android.R
import android.content.Context
import android.util.Log.d
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.AdListener
import com.facebook.ads.AdSize
import com.facebook.ads.AdView


object FbBannerADs {
    private var adView: AdView? = null
    fun FbBannerads(context: Context,adContainer:LinearLayout){
        adView = AdView(context, "IMG_16_9_APP_INSTALL#YOUR_PLACEMENT_ID", AdSize.BANNER_HEIGHT_50)
        adContainer.addView(adView)
        adView!!.loadAd()
        val adListener = object : AdListener {
            override fun onError(ad: Ad, adError: AdError) {
                d("FBADS",adError.errorMessage.toString())

            }

            override fun onAdLoaded(ad: Ad) {
                d("FBADS","FB Banner AD loded")
                adContainer.visibility= View.VISIBLE
            }

            override fun onAdClicked(ad: Ad) {
                // Ad clicked callback
            }

            override fun onLoggingImpression(ad: Ad) {
                // Ad impression logged callback
            }
        }

// Request an ad
     }

}