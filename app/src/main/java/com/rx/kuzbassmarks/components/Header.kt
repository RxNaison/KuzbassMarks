package com.rx.kuzbassmarks.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.rx.kuzbassmarks.R

@Composable
fun Header(onFaqClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(R.color.LightOrange))
    ) {
        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
                .clickable { onFaqClick() }
                .drawBehind {
                    drawRoundRect(
                        color = Color.DarkGray,
                        style = Stroke(
                            width = 2.dp.toPx(),
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                        ),
                        cornerRadius = CornerRadius(8.dp.toPx(), 8.dp.toPx())
                    )
                }
                .padding(horizontal = 8.dp, vertical = 2.dp)
        ) {
            Text(text = stringResource(R.string.FAQ), color = Color.DarkGray)
        }
    }
}
