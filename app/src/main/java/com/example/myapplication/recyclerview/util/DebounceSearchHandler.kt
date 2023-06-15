package com.example.myapplication.recyclerview.util

import android.os.Handler
import android.os.Looper

class DebounceSearchHandler(private val debounceDelay: Long) {
    private var handler: Handler? = null
    private var runnable: Runnable? = null

    fun debounceSearch(text: String, callback: (String) -> Unit) {
        handler?.removeCallbacks(runnable ?: return)
        handler = Handler(Looper.getMainLooper())
        runnable = Runnable { callback(text) }
        handler?.postDelayed(runnable ?: return, debounceDelay)
    }

    fun cancelSearch() {
        handler?.removeCallbacks(runnable ?: return)
    }
}