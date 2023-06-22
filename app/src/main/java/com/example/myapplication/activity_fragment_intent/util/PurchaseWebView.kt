package com.example.myapplication.activity_fragment_intent.util

import android.graphics.Bitmap
import android.util.Log
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.core.widget.ContentLoadingProgressBar
import com.airbnb.lottie.LottieAnimationView

class PurchaseWebView(
    private val progressBar: ContentLoadingProgressBar,
    private val errorAnim: LottieAnimationView
) : WebViewClient() {
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        Log.d("TAG", "onPageFinished: ")
    }

    override fun onPageCommitVisible(view: WebView?, url: String?) {
        super.onPageCommitVisible(view, url)
        progressBar.hide()
        Log.d("TAG", "onPageCommitVisible: ")
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        Log.d("TAG", "onPageStarted: ")
    }

    override fun onReceivedError(
        view: WebView?,
        request: WebResourceRequest?,
        error: WebResourceError?
    ) {
        errorAnim.visibility = View.VISIBLE
        super.onReceivedError(view, request, error)
    }

    override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
        if (request?.url?.host == "www.google.com") {
            if (view?.visibility == View.GONE) {
                view.visibility = View.VISIBLE
                errorAnim.visibility = View.GONE
            }
            return false
        }
        view?.visibility = View.GONE
        errorAnim.visibility = View.VISIBLE
        return true
    }
}