package com.rx.kuzbassmarks

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.rx.kuzbassmarks.ui.theme.KuzbassMarksTheme
import com.rx.kuzbassmarks.screens.MapScreen
import com.rx.kuzbassmarks.utils.AndroidConnectivityObserver
import com.rx.kuzbassmarks.utils.ConnectivityViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KuzbassMarksTheme {
                val viewModel = viewModel<ConnectivityViewModel> {
                    ConnectivityViewModel(
                        connectivityObserver = AndroidConnectivityObserver(
                            context = applicationContext
                        )
                    )
                }
                val isConnected by viewModel.isConnected.collectAsStateWithLifecycle()
                MapScreen(isConnected)
            }
        }
    }
}