package com.example.secondlabassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.secondlabassignment.R.layout.webview_layout

class WebActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(webview_layout) // Set the content view to the specified XML layout file

        // Find the WebView element in the layout XML
        val webView = findViewById<WebView>(R.id.webView)

        // Configure WebView settings
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true // Enable JavaScript in the WebView

        // Clear the WebView cache before loading the URL to ensure a fresh load
        webView.clearCache(true)

        // Load the desired URL in the WebView
        webView.loadUrl("https://emayanvadivel.netlify.app/")
        webView.webViewClient = WebViewClient() // Links open within the WebView
    }
}
