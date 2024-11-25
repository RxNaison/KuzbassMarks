package com.rx.kuzbassmarks

import android.content.Intent
import android.net.Uri
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.rx.kuzbassmarks.ui.theme.KuzbassMarksTheme


@Composable
fun ModelViewerWebView() {

//    val context = LocalContext.current
//
//    Box(modifier = Modifier.fillMaxSize()) {
//        // Create the intent for Scene Viewer
//        val sceneViewerIntent = Intent(Intent.ACTION_VIEW)
//        val intentUri =
//            Uri.parse("https://arvr.google.com/scene-viewer/1.0").buildUpon()
//                .appendQueryParameter(
//                    "file",
//                    "https://modelviewer.dev/shared-assets/models/Astronaut.glb"
//                )
//                .build()
//        sceneViewerIntent.setData(intentUri)
//        sceneViewerIntent.setPackage("com.google.ar.core")
//        context.startActivity(sceneViewerIntent)
//
//    }

    Box(modifier = Modifier.fillMaxSize()) {
        AndroidView(
            modifier = Modifier.fillMaxSize(),
            factory = { context ->
                WebView(context).apply {
                    layoutParams = ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                    )
                    webViewClient = WebViewClient()
                    settings.javaScriptEnabled = true
                    settings.domStorageEnabled = true
                    loadUrl("file:///android_asset/html/modelViewer.html")
                }
            })
    }


}


@Preview(showBackground = true)
@Composable
fun ModelViewerPreview() {
    KuzbassMarksTheme {
        ModelViewerWebView()
    }
}
