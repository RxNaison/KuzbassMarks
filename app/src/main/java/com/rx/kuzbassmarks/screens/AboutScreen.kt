package com.rx.kuzbassmarks.screens

import StoryLine
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rx.kuzbassmarks.utils.ModelViewerWebView
import com.rx.kuzbassmarks.models.Place
import com.rx.kuzbassmarks.R
import com.rx.kuzbassmarks.ui.theme.KuzbassMarksTheme

@Composable
fun AboutScreen(place: Place, isConnected:Boolean, onClose: () -> Unit) {
    val LightOrange = colorResource(R.color.LightOrange)
    val DarkBlue = colorResource(R.color.DarkBlue)
    val Blue = colorResource(R.color.Blue)
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
                    .clickable { onClose() }
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

            Box(
                modifier = Modifier
                    .padding(top = 30.dp, start = 8.dp)
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
                if (!isModelViewerVisible)
                    Text(text = stringResource(R.string.showModel), color = Color.DarkGray)
                else
                    Text(text = stringResource(R.string.hideModel), color = Color.DarkGray)
            }

        AnimatedVisibility(
            visible = isModelViewerVisible
        ) {
            Box(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(500.dp)
                    .padding(top = 2.dp, start = 20.dp, end = 20.dp)
            )
            {
                if(isConnected)
                    ModelViewerWebView(place.modelPath)
                else
                    NoConnectionScreen(isConnected)
            }
        }

        Box(
            modifier = Modifier
                .padding(top = 20.dp)
                .align(Alignment.CenterHorizontally)
                .fillMaxWidth()
        ) {
            Text(
                text = place.fullStory.trimIndent(),
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .padding(start = 50.dp)
                    .width(280.dp)
                    .onGloballyPositioned { layoutCoordinates ->
                        fullStoryHeight.value = layoutCoordinates.size.height
                    }
            )
            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(end = 30.dp)
            )
            {
                var count by remember { mutableStateOf(0) }
                Image(
                    painter = painterResource(id = R.drawable.dimond),
                    contentDescription = "Dimond",
                    modifier = Modifier
                        .size(20.dp)
                        .clickable {
                            count++
                            if(count >= 10)
                                place.modelPath = "NeilArmstrong.glb"
                        }
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
                .padding(vertical = 20.dp, horizontal = 8.dp)
                .fillMaxWidth()
                .border(2.dp, colorResource(R.color.Orange), RoundedCornerShape(5.dp))
                .padding(horizontal = 8.dp, vertical = 2.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(text = stringResource(R.string.iventsMap), color = Color.DarkGray)
        }

        StoryLine(
            years = place.years,
            storyLine = place.storyLine
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(40.dp)
                .background(Blue, RoundedCornerShape(5.dp))
                .clickable {
                    openExternalMap(context, place.latitude, place.longitude, place.title)
                }
                .padding(10.dp)
        ) {
            Text(
                text = stringResource(R.string.showOnMap),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

private fun openExternalMap(context: Context, latitude: Double, longitude: Double, label: String)
{
    val uri = Uri.parse("geo:$latitude,$longitude?q=$latitude,$longitude($label)")
    val intent = Intent(Intent.ACTION_VIEW, uri)
    context.startActivity(intent)
}

