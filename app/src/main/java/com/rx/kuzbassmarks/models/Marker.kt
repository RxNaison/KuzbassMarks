package com.rx.kuzbassmarks.models

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rx.kuzbassmarks.R

@Composable
fun Marker(place: Place, isSelected: Boolean, modifier: Modifier = Modifier) {
    val markerSize by animateDpAsState(
        targetValue = if(isSelected) 45.dp else 40.dp,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessVeryLow
        )
    )
    val Yellow = colorResource(R.color.Yellow)
    val Orange2 = colorResource(R.color.Orange2)
    val markerColor = if (isSelected) Yellow else Orange2
    Image(
        painter = painterResource(id = R.drawable.mark),
        contentDescription = "Marker",
        colorFilter = ColorFilter.tint(markerColor),
        modifier = modifier.size(markerSize)
    )
}