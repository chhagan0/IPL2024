package com.cxzcodes.ipllivescoreandschedule2024.Utils

import android.content.Context
import android.preference.PreferenceManager

object Utils {

    fun notification(context:Context){
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val ADMOB = sharedPreferences.getBoolean("ADMOB", true)
        val FBADS = sharedPreferences.getBoolean("FBADS", true)
    }
}