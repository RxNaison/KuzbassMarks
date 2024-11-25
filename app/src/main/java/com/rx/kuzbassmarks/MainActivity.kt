package com.rx.kuzbassmarks

import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rx.kuzbassmarks.ui.theme.KuzbassMarksTheme
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import com.rx.kuzbassmarks.ui.theme.*


data class Place(
    val x: Float,
    val y: Float,
    val title: String,
    val storyline: String,
    val fullStory: String
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            KuzbassMarksTheme {
                ModelViewerWebView()
            }
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MapScreen() {
    val context = LocalContext.current
    val mapImage: Painter = painterResource(id = R.drawable.map)
    val places = remember {
        listOf(
            Place(0.2f, 0.2f, "Place 1", "Storyline for Place 1", "Full 1"),
            Place(0.25f, 0.25f, "Place 2", "Storyline for Place 2", "Full 2"),
            Place(0.66f, 0.11f, "Place 3", "Storyline for Place 3", "Full 3"),
            Place(0.7f, 0.15f, "Place 4", "Storyline for Place 4", "Full 4"),
            Place(0.55f, 0.65f, "Place 5", "Storyline for Place 5", "Full 5"),
            Place(0.83f, 0.86f, "Place 6", "Storyline for Place 6", "Full 6"),
        )
    }
    var selectedPlace by remember { mutableStateOf<Place?>(null) }
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by remember { mutableStateOf(false) }
    var isAboutScreenVisible by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .align(Alignment.TopCenter)
                .fillMaxWidth()
                .background(LightOrange)
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(8.dp)
                    .clickable {
                        val url = "https://krakishmusta.github.io/FAQ/"
                        val builder = CustomTabsIntent.Builder()
                        val customTabsIntent = builder.build()
                        customTabsIntent.launchUrl(context, Uri.parse(url))
                    }
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
                Text(text = stringResource(R.string.FAQ), color = Color.DarkGray)
            }
        }

        BoxWithConstraints(
            modifier = Modifier
                .fillMaxSize()
                .align(Alignment.Center)
                .padding(25.dp, 60.dp, 25.dp, 150.dp)
        ) {
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
                        .clickable {
                            selectedPlace = place
                            isSheetOpen = selectedPlace == null
                        }
                )
            }
        }

        selectedPlace?.let { place ->
            ModalBottomSheet(
                containerColor = Color.White,
                sheetState = sheetState,
                onDismissRequest = {
                    isSheetOpen = false
                    selectedPlace = null
                    isAboutScreenVisible = false
                }

            ) {
                if (!isAboutScreenVisible) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(text = place.title, fontSize = 18.sp, color = Color.Black)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = place.storyline,
                            fontSize = 14.sp,
                            color = Color.Gray,
                            maxLines = 3
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        TextButton(
                            onClick = {
                                isAboutScreenVisible = true
                            },
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text(text = stringResource(R.string.details), color = Color.Blue)
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .verticalScroll(rememberScrollState())
                ) {
                    AnimatedVisibility(
                        visible = isAboutScreenVisible
                    ) {
                        AboutScreen(place)
                    }
                }


            }

        }


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
                .align(Alignment.BottomCenter)
        ) {
            Text(
                text = stringResource(R.string.appDescription).trimIndent(),
                fontSize = 14.sp,
                color = Color.DarkGray
            )
        }

    }
}

@Composable
fun Marker(place: Place, isSelected: Boolean, modifier: Modifier = Modifier) {
    val markerColor = if (isSelected) Yellow else Orange2
    Image(
        painter = painterResource(id = R.drawable.mark),
        contentDescription = "Marker",
        colorFilter = ColorFilter.tint(markerColor),
        modifier = modifier.size(40.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun MapScreenPreview() {
    KuzbassMarksTheme {
        MapScreen()
    }
}