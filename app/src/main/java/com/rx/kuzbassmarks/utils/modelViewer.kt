package com.rx.kuzbassmarks.utils

import android.content.Intent
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun ModelViewerWebView(modelUrl: String, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val webView = remember { WebView(context) }

    val interactionModifier = modifier.pointerInput(Unit) {
        awaitEachGesture {
                awaitFirstDown(requireUnconsumed = false)
                webView.parent.requestDisallowInterceptTouchEvent(true)

                var event: androidx.compose.ui.input.pointer.PointerEvent
                do {
                    event = awaitPointerEvent()
                } while (event.changes.any { it.pressed })

                webView.parent.requestDisallowInterceptTouchEvent(false)

        }
    }

    AndroidView(
        modifier = interactionModifier,
        factory = {
            webView.apply {
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
                            false
                        }
                    }
                }
                settings.javaScriptEnabled = true
                settings.domStorageEnabled = true
            }
        },
        update = { view ->
            val finalUrl = "file:///android_asset/html/modelViewer.html?modelUrl=" +
                    "https://raw.githubusercontent.com/RxNaison/KuzbassMarks/main/app/src/main/assets/models/$modelUrl"
            view.loadUrl(finalUrl)
        }
    )
}