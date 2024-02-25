package com.cxzcodes.ipllivescoreandschedule2024

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.DisplayMetrics
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.webkit.WebChromeClient
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ProgressBar
import androidx.constraintlayout.widget.ConstraintLayout
import com.cxzcodes.ipllivescoreandschedule2024.Ads.BannerADs
import com.cxzcodes.ipllivescoreandschedule2024.Ads.FBADs.FbBannerADs
import com.cxzcodes.ipllivescoreandschedule2024.databinding.ActivityLiveScoreBinding
import com.cxzcodes.ipllivescoreandschedule2024.databinding.ActivityTableBinding
import im.delight.android.webview.AdvancedWebView
import java.util.PrimitiveIterator

class TableActivity : AppCompatActivity(), AdvancedWebView.Listener {
    lateinit var binding: ActivityTableBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTableBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.ivbtnback.setOnClickListener { finish() }
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val admob = sharedPreferences.getBoolean("ADMOB", true)
        val fbads = sharedPreferences.getBoolean("FBADS", true)
        if (admob==true){
            BannerADs.bannerADShow(this,binding.adView)

        }else if (fbads==true){
            FbBannerADs.FbBannerads(this,binding.bannerContainer2)

        }
        if (!isInternetAvailable()) {
            showLangDialouge()
        }
        binding.webview.setListener(this, this);
        binding.webview.setMixedContentAllowed(false);
        binding.webview.loadUrl("https://www.google.com/search?q=ipl+schedule+2023&client=ms-android-xiaomi-rvo2b&sxsrf=AJOqlzUtZebl_jiJAEu9FvUCnBuT_rjvhQ%3A1679233750563&ei=1hIXZNaAIpmD4-EP6JWo-A0&oq=ipl+schedule+2023&gs_lcp=ChNtb2JpbGUtZ3dzLXdpei1zZXJwEAMyEAgAEIAEEBQQhwIQsQMQgwEyCwgAEIAEELEDEIMBMgsIABCABBCxAxCDATILCAAQgAQQsQMQgwEyCggAEIAEEAIQywEyCwgAEIAEELEDEIMBMgoIABCABBAUEIcCMgUIABCABDoKCAAQRxDWBBCwAzoHCAAQsAMQQzoHCCMQ6gIQJzoECCMQJzoFCAAQkQI6CwguEIAEELEDEIMBOggIABCxAxCDAToKCAAQsQMQgwEQQzoLCAAQsQMQgwEQkQI6CgguELEDEIMBEEM6DQguELEDEIMBEOUEEEM6BAgAEEM6EAgAEIAEELEDEIMBEAIQnwE6EAgAELEDEIMBEAIQnwEQkQJKBAhBGABQ7w9Y4Thg9DtoAnAAeACAAaEDiAG0HJIBCTAuMy40LjUuMZgBAKABAbABD8gBEcABAQ&sclient=mobile-gws-wiz-serp#cobssid=s&sie=lg;/g/11q99yy05p;5;/m/03b_lm1;st;fp;1;;;")
    }

    override fun onPageStarted(url: String?, favicon: Bitmap?) {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onPageFinished(url: String?) {
        binding.progressBar.visibility = View.GONE
    }

    override fun onPageError(errorCode: Int, description: String?, failingUrl: String?) {
        // Handle error if needed
    }

    override fun onDownloadRequested(
        url: String?,
        suggestedFilename: String?,
        mimeType: String?,
        contentLength: Long,
        contentDisposition: String?,
        userAgent: String?
    ) {
        // Handle file download request if needed
    }

    override fun onExternalPageRequest(url: String?) {
        // Handle external page request if needed
    }
    fun showLangDialouge() {


        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(true)
        dialog.setCanceledOnTouchOutside(true)
        dialog.setContentView(R.layout.no_internet_dialog)

        val backBtn: ConstraintLayout = dialog.findViewById(R.id.noIntCC)

        backBtn.setOnClickListener {
            finish()        }

        dialog.setCanceledOnTouchOutside(true)
        dialog.show()
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val displayWidth: Int = displayMetrics.widthPixels
        val displayHeight: Int = displayMetrics.heightPixels
        val layoutParams: WindowManager.LayoutParams = WindowManager.LayoutParams()
        layoutParams.copyFrom(dialog.window!!.attributes)
        val dialogWindowWidth = (displayWidth * 0.9f).toInt()
        val dialogWindowHeight = (displayHeight * 0.5f).toInt()
        layoutParams.width = dialogWindowWidth
        layoutParams.height = dialogWindowHeight
        dialog.window!!.attributes = layoutParams

    }
    private fun isInternetAvailable(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        return activeNetwork?.isConnectedOrConnecting == true
    }
}