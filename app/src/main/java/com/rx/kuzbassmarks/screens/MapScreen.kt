package com.rx.kuzbassmarks.screens

import android.graphics.Paint
import com.rx.kuzbassmarks.components.*
import com.rx.kuzbassmarks.models.Place

import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.rotate
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rx.kuzbassmarks.models.getPlaces
import com.rx.kuzbassmarks.R

@Preview
@Composable
fun MapScreen() {
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

