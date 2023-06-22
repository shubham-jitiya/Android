package com.example.myapplication.activity_fragment_intent.uiwidgets

import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.activity_fragment_intent.Constants
import com.example.myapplication.databinding.ActivityWebViewBinding
import com.example.myapplication.activity_fragment_intent.util.PurchaseWebView
import com.example.myapplication.activity_fragment_intent.util.WebAppInterface

class WebViewActivity : AppCompatActivity() {
    private lateinit var binding: ActivityWebViewBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityWebViewBinding.inflate(layoutInflater)
        initialSetup(Constants.WEB_URL, savedInstanceState)
        binding.fabMore.setOnClickListener {
            Toast.makeText(this, "More tapped", Toast.LENGTH_SHORT).show()
        }
        setContentView(binding.root)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        binding.webView.saveState(outState)
    }

    private fun initialSetup(url: String, savedInstanceState: Bundle?) {
        with(binding.webView) {
            if (savedInstanceState != null) {
                binding.webView.restoreState(savedInstanceState)
            } else {
                binding.webView.loadUrl(url)
            }
            // Uncomment below code and comment above snippet to load custom webpage and integrate js
            /*     loadCustomWebpage(
                     "<input type=\"button\" value=\"Say hello\" onClick=\"showAndroidToast('Hello Android!')\" />\n" +
                             "\n" +
                             "<script type=\"text/javascript\">\n" +
                             "    function showAndroidToast(toast) {\n" +
                             "        Android.showToast(toast);\n" +
                             "    }\n" +
                             "</script>"
                 )*/
            settings.javaScriptEnabled = true
            webViewClient = PurchaseWebView(binding.progressBar, binding.errorAnim)
            addJavascriptInterface(WebAppInterface(this@WebViewActivity), "Android")
        }
    }

    private fun loadCustomWebpage(html: String) {
        binding.webView.loadData(html, "text/html", null)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == KeyEvent.KEYCODE_BACK && binding.webView.canGoBack()) {
            if (binding.webView.visibility == View.GONE) {
                binding.webView.visibility = View.VISIBLE
                binding.errorAnim.visibility = View.GONE
            } else {
                binding.webView.goBack()
            }
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
}