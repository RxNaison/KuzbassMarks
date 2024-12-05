package com.rx.kuzbassmarks.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rx.kuzbassmarks.R

@Composable
fun Footer() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .drawBehind {
                drawRoundRect(
                    color = Color.LightGray,
                    style = Stroke(
                        width = 2.dp.toPx(),
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 10f), 0f)
                    ),
                    cornerRadius = CornerRadius(8.dp.toPx(), 8.dp.toPx())
                )
            }
            .padding(8.dp)

    ) {
        Text(
            text = stringResource(R.string.appDescription).trimIndent(),
            fontSize = 14.sp,
            color = Color.DarkGray
        )
    }
}
