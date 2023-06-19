package mende273.viewpagerexamples.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mende273.viewpagerexamples.util.getBackgroundColorForItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun VerticalPagerScreen() {
    val pagerState = rememberPagerState()
    VerticalPager(
        pageCount = 10,
        pageSize = PageSize.Fixed(300.dp),
        state = pagerState
    ) { page ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(getBackgroundColorForItem(page)),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Page: $page")
        }
    }
}