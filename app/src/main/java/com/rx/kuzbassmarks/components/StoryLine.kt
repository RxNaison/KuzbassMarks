import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.collectIsDraggedAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.rx.kuzbassmarks.R
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.math.abs


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StoryLine(
    years: List<String>,
    storyLine: List<String>,
    autoScrollDuration: Long = 10000L,
) {
    val pagerState = rememberPagerState(pageCount = { years.size })
    val isDragged by pagerState.interactionSource.collectIsDraggedAsState()

    if (!isDragged) {
        with(pagerState) {
            var currentPageKey by remember { mutableStateOf(0) }
            LaunchedEffect(key1 = currentPageKey) {
                launch {
                    delay(autoScrollDuration)
                    val nextPage = (currentPage + 1).mod(pageCount)
                    animateScrollToPage(page = nextPage)
                    currentPageKey = nextPage
                }

            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        Box(
            modifier = Modifier
                .background(
                    color = colorResource(R.color.Orange),
                    shape = RoundedCornerShape(16.dp)
                )
                .wrapContentHeight()
                .align(Alignment.TopCenter)
                .width(180.dp)
        ) {
            Text(
                text = storyLine[pagerState.currentPage],
                modifier = Modifier
                    .padding(top = 180.dp, start = 10.dp, end = 10.dp, bottom = 20.dp)
                    .align(Alignment.Center),
                style = MaterialTheme.typography.bodyLarge,
            )
        }
        HorizontalPager(
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 120.dp),
        ) { page ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp)
                    .carouselTransition(page, pagerState),
                contentAlignment = Alignment.Center
            ) {
                EllipseItem(year = years[page], isSelected = pagerState.currentPage == page)
            }
        }
    }
}

@Composable
fun EllipseItem(year: String, isSelected: Boolean) {
    val size by animateDpAsState(if (isSelected) 150.dp else 100.dp)
    val fontSize = (size.value / 5).sp
    Box(
        modifier = Modifier
            .size(size)
            .background(Color(0xFFB07356), shape = CircleShape),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = year,
            color = Color.White,
            style = MaterialTheme.typography.headlineMedium.copy(fontSize = fontSize)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Modifier.carouselTransition(page: Int, pagerState: PagerState): Modifier {
    val pageOffset = calculateCurrentOffsetForPage(page, pagerState)
    val scale = 1f - abs(pageOffset) * 0.1f
    val alpha = 1f - abs(pageOffset) * 0.5f

    return this.graphicsLayer {
        scaleX = scale
        scaleY = scale
        this.alpha = alpha
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun calculateCurrentOffsetForPage(page: Int, pagerState: PagerState): Float {
    val currentPageOffset = pagerState.currentPageOffsetFraction
    return (page - pagerState.currentPage) + currentPageOffset
}

@Preview(showBackground = true)
@Composable
fun PreviewStoryLine() {
    StoryLine(
        listOf("1234", "2234", "32434", "2349", "3432", "2342"),
        listOf("mlgfb; fdgknlfgraeeeeeeeeeeeee eeeeeeeeeeee eegareeeeeeeee eeeeeeeeee eeeeeeekl", "efef", "efef", "efeef", "efefe", "ewfef"),
        autoScrollDuration = 3000L,
    )
}