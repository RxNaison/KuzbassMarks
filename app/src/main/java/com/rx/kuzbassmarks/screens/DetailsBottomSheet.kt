package com.rx.kuzbassmarks.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rx.kuzbassmarks.models.Place
import com.rx.kuzbassmarks.R
import com.rx.kuzbassmarks.ui.theme.LightOrange


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsBottomSheet(
    place: Place,
    isAboutVisible: Boolean,
    onClose: () -> Unit,
    onDetailsClick: () -> Unit
) {

    var isSubPlaceAboutVisible by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()
    val size = (place.subPlaces?.size ?: 0) + 1
    val isVisible = remember { mutableStateListOf(*Array(size) { true })}

    ModalBottomSheet(
        sheetState = sheetState,
        containerColor = Color.White,
        onDismissRequest = onClose
    ) {
        Column {
            ShowPlaceInfo(
                place = place,
                isAboutVisible = isAboutVisible,
                isVisible = isVisible[0],
                onClose,
                onDetailsClick = {
                    isVisible.indices.forEach { isVisible[it] = it == 0 }
                    onDetailsClick()
                }
            )

            place.subPlaces?.forEachIndexed { index, subPlace ->
                HorizontalDivider(
                    thickness = 1.dp,
                    color = Color.Gray
                )
                ShowPlaceInfo(
                    place = subPlace,
                    isAboutVisible = isSubPlaceAboutVisible,
                    isVisible = isVisible[index + 1],
                    onClose,
                    onDetailsClick = {
                        isVisible.indices.forEach { isVisible[it] = it == index + 1 }
                        isSubPlaceAboutVisible = true
                    }
                )
            }
        }
    }

}

@Composable
private fun ShowPlaceInfo(
    place: Place,
    isAboutVisible: Boolean,
    isVisible: Boolean,
    onClose: () -> Unit,
    onDetailsClick: () -> Unit
) {
    if(isVisible) {
        if (!isAboutVisible) {
            Column(
                modifier = Modifier
                .fillMaxWidth()
            ) {
                Text(
                    text = place.title,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(start = 8.dp, top = 10.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = place.quickAbout,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Spacer(modifier = Modifier.height(8.dp))
                TextButton(
                    onClick = onDetailsClick,
                    modifier = Modifier
                        .align(Alignment.End)
                        .padding(20.dp)
                        .drawBehind {
                            drawRoundRect(
                                color = LightOrange,
                                cornerRadius = CornerRadius(20.dp.toPx())
                            )

                        }
                ) {
                    Text(text = stringResource(R.string.details), color = Color.Black)
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            AnimatedVisibility(
                visible = isAboutVisible,
                enter = slideInVertically(initialOffsetY = { fullHeight -> fullHeight })
            ) {
                AboutScreen(place, onClose)
            }
        }
    }
}
