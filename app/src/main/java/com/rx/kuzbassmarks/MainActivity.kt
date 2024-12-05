package com.rx.kuzbassmarks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import com.rx.kuzbassmarks.ui.theme.KuzbassMarksTheme
import com.rx.kuzbassmarks.screens.MapScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KuzbassMarksTheme {
                MapScreen()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview() {
    KuzbassMarksTheme {
        MapScreen()
    }
}