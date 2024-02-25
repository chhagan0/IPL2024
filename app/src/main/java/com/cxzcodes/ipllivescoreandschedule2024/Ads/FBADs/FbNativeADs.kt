package com.cxzcodes.ipllivescoreandschedule2024.Ads.FBADs

 import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.cxzcodes.ipllivescoreandschedule2024.R
import com.facebook.ads.Ad
import com.facebook.ads.AdError
import com.facebook.ads.AdOptionsView
import com.facebook.ads.AdView
import com.facebook.ads.MediaView
import com.facebook.ads.NativeAd
import com.facebook.ads.NativeAdLayout
import com.facebook.ads.NativeAdListener


object FbNativeADs {
      fun loadNativeAd(context: Context,nativeAdLayout:NativeAdLayout) {
        val TAG = "CHAGAN"
          lateinit var adView: View
        // Instantiate a NativeAd object.
        // NOTE: the placement ID will eventually identify this as your App, you can ignore it for
        // now, while you are testing and replace it later when you have signed up.
        // While you are using this temporary code you will only get test ads and if you release
        // your code like this to the Google Play your users will not receive ads (you will get a no fill error).
        val nativeAd = NativeAd(context, "YOUR_PLACEMENT_ID")

        val nativeAdListener = object : NativeAdListener {
            override fun onMediaDownloaded(ad: Ad) {
                // Native ad finished downloading all assets
                Log.e(TAG, "Native ad finished downloading all assets.")
            }

            override fun onError(ad: Ad, adError: AdError) {
                // Native ad failed to load
                Log.e(TAG, "Native ad failed to load: ${adError.errorMessage}")
            }

            override fun onAdLoaded(ad: Ad) {
                if (nativeAd == null || nativeAd != ad) {
                    return;
                }
                nativeAd.unregisterView()


                val inflater = LayoutInflater.from(context)
                 // Inflate the Ad view.
                adView = inflater.inflate(
                    com.cxzcodes.ipllivescoreandschedule2024.R.layout.fb_native_layout,
                    nativeAdLayout,
                    false
                ) as LinearLayout

                // adding view
                nativeAdLayout.addView(adView)

                // Add the AdOptionsView
                val adChoicesContainer: LinearLayout = adView.findViewById(com.cxzcodes.ipllivescoreandschedule2024.R.id.ad_choices_container)
                val adOptionsView = AdOptionsView(context, nativeAd, nativeAdLayout)
                adChoicesContainer.removeAllViews()
                adChoicesContainer.addView(adOptionsView, 0)

                // Create native UI using the ad metadata.
                val nativeAdIcon: MediaView = adView.findViewById(com.cxzcodes.ipllivescoreandschedule2024.R.id.native_ad_icon)
                val nativeAdTitle: TextView = adView.findViewById(com.cxzcodes.ipllivescoreandschedule2024.R.id.native_ad_title)
                val nativeAdMedia: MediaView = adView.findViewById(com.cxzcodes.ipllivescoreandschedule2024.R.id.native_ad_media)
                val nativeAdSocialContext: TextView =
                    adView.findViewById(com.cxzcodes.ipllivescoreandschedule2024.R.id.native_ad_social_context)
                val nativeAdBody: TextView = adView.findViewById(com.cxzcodes.ipllivescoreandschedule2024.R.id.native_ad_body)
                val sponsoredLabel: TextView = adView.findViewById(com.cxzcodes.ipllivescoreandschedule2024.R.id.native_ad_sponsored_label)
                val nativeAdCallToAction: Button =
                    adView.findViewById(com.cxzcodes.ipllivescoreandschedule2024.R.id.native_ad_call_to_action)

                // Setting  the Text.
                nativeAdTitle.text = nativeAd.advertiserName
                nativeAdBody.text = nativeAd.adBodyText
                nativeAdSocialContext.text = nativeAd.adSocialContext
                nativeAdCallToAction.visibility =
                    if (nativeAd.hasCallToAction()) View.VISIBLE else View.INVISIBLE
                nativeAdCallToAction.text = nativeAd.adCallToAction
                sponsoredLabel.text = nativeAd.sponsoredTranslation

                // Create a list of clickable views
                val clickableViews: MutableList<View> = ArrayList()
                clickableViews.add(nativeAdTitle)
                clickableViews.add(nativeAdCallToAction)

                // Register the Title and  button to listen for clicks.
                nativeAd.registerViewForInteraction(adView, nativeAdMedia, nativeAdIcon, clickableViews)


                         }

            override fun onAdClicked(ad: Ad) {
                // Native ad clicked
                Log.d(TAG, "Native ad clicked!")
            }

            override fun onLoggingImpression(ad: Ad) {
                // Native ad impression
                Log.d(TAG, "Native ad impression logged!")
            }
        }

        // Request an ad
        nativeAd.loadAd(
            nativeAd.buildLoadAdConfig()
                .withAdListener(nativeAdListener)
                .build()
        )
     }


}