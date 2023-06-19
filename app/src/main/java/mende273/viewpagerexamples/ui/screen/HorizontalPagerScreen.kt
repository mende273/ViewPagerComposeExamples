package mende273.viewpagerexamples.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import mende273.viewpagerexamples.ui.component.ViewPagerItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerScreen() {
    val pagerState = rememberPagerState()
    HorizontalPager(pageCount = 10, state = pagerState) { page ->
        ViewPagerItem(page = page)
    }
}

@Preview
@Composable
private fun HorizontalPagerScreenPreview() {
    HorizontalPagerScreen()
}