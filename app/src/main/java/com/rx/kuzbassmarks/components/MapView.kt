package com.rx.kuzbassmarks.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rx.kuzbassmarks.models.Marker
import com.rx.kuzbassmarks.models.Place
import com.rx.kuzbassmarks.R

@Composable
fun MapView(
    places: List<Place>,
    selectedPlace: Place?,
    onPlaceClick: (Place) -> Unit
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .padding(25.dp, 60.dp, 25.dp, 150.dp)
    ) {
        val mapImage: Painter = painterResource(id = R.drawable.map)
        val mapWidth = constraints.maxWidth.toFloat()
        val mapHeight = constraints.maxHeight.toFloat()
        val locDensity = LocalContext.current.resources.displayMetrics.density

        Image(
            painter = mapImage,
            contentDescription = stringResource(R.string.KuzbassMap),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.fillMaxSize()
        )

        places.forEach { place ->
            val isSelected = selectedPlace == place
            Marker(
                place = place,
                isSelected = isSelected,
                modifier = Modifier
                    .offset(
                        x = (place.x * mapWidth / locDensity).dp - 15.dp,
                        y = (place.y * mapHeight / locDensity).dp - 30.dp
                    )
                    .clickable { onPlaceClick(place) }
            )
        }
    }
}
