package com.rx.kuzbassmarks

import android.widget.Toast
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rx.kuzbassmarks.ui.theme.Blue
import com.rx.kuzbassmarks.ui.theme.DarkBlue
import com.rx.kuzbassmarks.ui.theme.KuzbassMarksTheme
import com.rx.kuzbassmarks.ui.theme.LightOrange
import com.rx.kuzbassmarks.ui.theme.Orange

@Composable
fun AboutScreen(place: Place) {
    Column(modifier = Modifier.fillMaxSize()) {
        var isModelViewerVisible by remember { mutableStateOf(false) }
        val fullStoryHeight = remember { mutableStateOf(0) }
        val context = LocalContext.current
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(LightOrange)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(8.dp)
                    .drawBehind {
                        drawRoundRect(
                            color = Color.DarkGray,
                            style = Stroke(
                                width = 2.dp.toPx(),
                                pathEffect = PathEffect.dashPathEffect(floatArrayOf(30f, 10f), 0f)
                            ),
                            cornerRadius = CornerRadius(8.dp.toPx(), 8.dp.toPx())
                        )
                    }
                    .padding(start = 8.dp, bottom = 2.dp, end = 8.dp, top = 2.dp)
                    .clickable { }
            ) {
                Text(text = stringResource(R.string.main), color = Color.DarkGray)
            }

        }

        Text(
            text = place.title,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 30.dp, start = 8.dp)
        )


        Row(
            modifier = Modifier
                .padding(top = 30.dp, start = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Box(
                modifier = Modifier
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
                    .padding(start = 8.dp, bottom = 2.dp, end = 8.dp, top = 2.dp)
                    .clickable {
                        isModelViewerVisible = !isModelViewerVisible
                    }
            ) {
                if(!isModelViewerVisible)
                    Text(text = stringResource(R.string.showModelBtn), color = Color.DarkGray)
                else
                    Text(text = stringResource(R.string.hideModelBtn), color = Color.DarkGray)
            }
            Box(
                modifier = Modifier
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
                    .padding(start = 8.dp, bottom = 2.dp, end = 8.dp, top = 2.dp)
            ) {
                Text(text = stringResource(R.string.info), color = Color.DarkGray)
            }
        }

        AnimatedVisibility(
            visible = isModelViewerVisible
        ) {
            Box(
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            {
                //ModelViewerWebView()
            }
        }

        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ){
            Text(
                text = place.fullStory,
                modifier = Modifier
                    .align(Alignment.Center)
                    .onGloballyPositioned { layoutCoordinates ->
                        fullStoryHeight.value = layoutCoordinates.size.height
                    }
            )
            Box(modifier = Modifier.align(Alignment.TopEnd)
                .padding(end = 30.dp))
            {
                Image(
                    painter = painterResource(id = R.drawable.dimond),
                    contentDescription = "Dimond",
                    modifier = Modifier
                        .size(20.dp)
                )
            }

            Canvas(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 10.dp, end = 40.dp)
            ) {
                drawLine(
                    color = DarkBlue,
                    start = Offset(size.width / 2, fullStoryHeight.value.dp.toPx() / 3),
                    end = Offset(size.width / 2, size.height),
                    strokeWidth = 3.dp.toPx()
                )
            }
        }


        Box(
            modifier = Modifier
                .padding(start = 8.dp, top = 20.dp)
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
            Text(text = stringResource(R.string.iventsMap), color = Color.DarkGray)
        }

        Box(
            modifier = Modifier.align(Alignment.CenterHorizontally)
                .pointerInput(Unit) {
                    detectHorizontalDragGestures(
                        onHorizontalDrag = { _, dragAmount ->
                            if (dragAmount < 0) {
                                Toast.makeText(context, "swipe left", Toast.LENGTH_SHORT).show()
                            } else if (dragAmount > 0) {
                                Toast.makeText(context, "swipe right", Toast.LENGTH_SHORT).show()
                            }
                        }
                    )
                }
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 40.dp)
                    .align(Alignment.Center)
                    .background(Orange)
            ) {
                Box(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ellipselarfe),
                        contentDescription = stringResource(R.string.elipse),
                        modifier = Modifier
                            .size(150.dp)
                    )
                }
                Text(
                    text = "???",
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 80.dp, start = 8.dp, end = 8.dp)
            ) {
                Box(
                    modifier = Modifier.align(Alignment.CenterStart)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ellipselarfe),
                        contentDescription = stringResource(R.string.elipse),
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
                Box(
                    modifier = Modifier.align(Alignment.CenterEnd)
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ellipselarfe),
                        contentDescription = "elipse",
                        modifier = Modifier
                            .size(100.dp)
                    )
                }
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp)
                .background(Blue)
        ) {
            Text(
                text = "button",
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AboutScreenPreview() {
    KuzbassMarksTheme {
        AboutScreen(
            Place(
                0.2f,
                0.2f,
                "Place 1",
                "Storyline for Place 1",
                "Full 1\nFull 1\nFull 1\nFull 1\nFull 1\nFull 1\nFull 1\nFull 1\nFull 1"
            )
        )
    }
}