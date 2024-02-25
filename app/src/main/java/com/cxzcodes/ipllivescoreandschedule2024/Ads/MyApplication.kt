package com.cxzcodes.ipllivescoreandschedule2024.Ads

import android.app.Application
import com.cxzcodes.ipllivescoreandschedule2024.R
import com.facebook.ads.AdSettings
import com.facebook.ads.AudienceNetworkAds
import com.google.android.gms.ads.MobileAds
import papaya.`in`.admobopenads.AppOpenManager

class MyApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        MobileAds.initialize(this)
        AppOpenManager(this, R.string.open_ADs.toString())
        AudienceNetworkAds.initialize(this);

        AdSettings.setTestMode(true)
        AdSettings.setIntegrationErrorMode(AdSettings.IntegrationErrorMode.INTEGRATION_ERROR_CRASH_DEBUG_MODE);
//        AdSettings.addTestDevice("328404cebf50ec1fdb05795c0007a8a7");

    }
}