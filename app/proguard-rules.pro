# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keep class com.cxzcodes.ipllivescoreandschedule2024.model.MatchModel
-keep class com.cxzcodes.ipllivescoreandschedule2024.model.ModelClass
-keep class com.cxzcodes.ipllivescoreandschedule2024.model.ScheduleModel
-keep class com.cxzcodes.ipllivescoreandschedule2024.model.TeamModel
-keep class com.cxzcodes.ipllivescoreandschedule2024.model.WinnerModel
-keep class com.cxzcodes.ipllivescoreandschedule2024.adapter.ItemAdapter
-keep class com.cxzcodes.ipllivescoreandschedule2024.adapter.MatchAdapter
-keep class com.cxzcodes.ipllivescoreandschedule2024.adapter.ScheduleAdapter
-keep class com.cxzcodes.ipllivescoreandschedule2024.adapter.ScheduleTeams
-keep class com.cxzcodes.ipllivescoreandschedule2024.adapter.TeamAdapter
-keep class com.cxzcodes.ipllivescoreandschedule2024.adapter.WinnerAdapter
-dontwarn okhttp3.internal.platform.**
-dontwarn org.conscrypt.**
-dontwarn org.bouncycastle.**
-dontwarn org.openjsse.**