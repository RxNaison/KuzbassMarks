package com.rx.kuzbassmarks.screens

import com.rx.kuzbassmarks.components.*
import com.rx.kuzbassmarks.models.Place

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import com.rx.kuzbassmarks.models.getPlaces
import com.rx.kuzbassmarks.R


@Composable
fun MapScreen(isConnected: Boolean) {
    val context = LocalContext.current
    val places = getPlaces()

    var selectedPlace by remember { mutableStateOf<Place?>(null) }
    var isSheetOpen by remember { mutableStateOf(false) }
    var isAboutScreenVisible by remember { mutableStateOf(false) }
    val faqUrl = stringResource(R.string.FAQ_URL)

    Box(modifier = Modifier.fillMaxSize()) {
        Header(
            onFaqClick = {
                CustomTabsIntent.Builder().build().launchUrl(context, Uri.parse(faqUrl))
            }
        )

        MapView(
            places = places,
            selectedPlace = selectedPlace,
            onPlaceClick = { place ->
                selectedPlace = place
                isSheetOpen = true
            }
        )

        selectedPlace?.let {
            DetailsBottomSheet(
                place = it,
                isAboutVisible = isAboutScreenVisible,
                isConnected,
                onClose = {
                    selectedPlace = null
                    isSheetOpen = false
                    isAboutScreenVisible = false
                },
                onDetailsClick = { isAboutScreenVisible = true }
            )
        }

        Box(Modifier.align(Alignment.BottomCenter))
        {
            Footer()
        }

    }
}

