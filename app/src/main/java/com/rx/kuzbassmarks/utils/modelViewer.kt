package com.rx.kuzbassmarks.utils

import android.content.Intent
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.rx.kuzbassmarks.ui.theme.KuzbassMarksTheme


@Composable
fun ModelViewerWebView(modelUrl: String) {

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = object : WebViewClient() {
                        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                            return if (url.startsWith("intent://")) {
                                try {
                                    val intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME)
                                    context.startActivity(intent)
                                    true
                                } catch (e: Exception) {
                                    e.printStackTrace()
                                    false
                                }
                            } else {
                                view.loadUrl(url)
                                true
                            }
                        }
                    }
                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true

                    val finalUrl = "file:///android_asset/html/modelViewer.html?modelUrl=" +
                            "https://raw.githubusercontent.com/RxNaison/KuzbassMarks/main/app/src/main/assets/models/$modelUrl"
                    loadUrl(finalUrl)
                }
            }
        )
    }



}


@Preview(showBackground = true)
@Composable
fun ModelViewerPreview() {
    KuzbassMarksTheme {
        //ModelViewerWebView()
    }
}
