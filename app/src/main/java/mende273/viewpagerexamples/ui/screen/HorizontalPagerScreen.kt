package mende273.viewpagerexamples.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mende273.viewpagerexamples.util.getBackgroundColorForItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerScreen() {
    val pagerState = rememberPagerState()
    HorizontalPager(pageCount = 10, state = pagerState) {page ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .background(getBackgroundColorForItem(page)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Page: $page")
        }
    }
}