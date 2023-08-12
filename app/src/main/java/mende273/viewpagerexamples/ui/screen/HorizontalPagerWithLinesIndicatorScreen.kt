package mende273.viewpagerexamples.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mende273.viewpagerexamples.ui.component.ViewPagerItem
import mende273.viewpagerexamples.ui.component.ViewPagerLinesIndicator

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerWithLinesIndicatorScreen() {
    val pageCount = 5
    val pagerState = rememberPagerState(pageCount = { pageCount })

    Box(modifier = Modifier) {
        HorizontalPager(state = pagerState) { page ->
            ViewPagerItem(page = page, Color.Gray)
        }

        ViewPagerLinesIndicator(
            modifier = Modifier
                .height(24.dp)
                .padding(start = 4.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            pageCount = pageCount,
            currentPageIteration = pagerState.currentPage
        )
    }
}

@Preview
@Composable
private fun HorizontalPagerWithLinesIndicatorScreenPreview() {
    HorizontalPagerWithLinesIndicatorScreen()
}