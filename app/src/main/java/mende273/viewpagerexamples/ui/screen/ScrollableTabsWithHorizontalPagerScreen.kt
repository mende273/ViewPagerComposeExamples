package mende273.viewpagerexamples.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mende273.viewpagerexamples.ui.component.TabIndicator
import mende273.viewpagerexamples.ui.component.TextComponent

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ScrollableTabsWithHorizontalPagerScreen() {
    val tabs = Array(20) { "Tab ${it + 1}" }

    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val coroutineScope = rememberCoroutineScope()

    Column {
        ScrollableTabRow(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            selectedTabIndex = pagerState.currentPage,
            edgePadding = 0.dp,
            divider = { Divider(color = MaterialTheme.colorScheme.background) },
            indicator = { TabIndicator(Modifier.tabIndicatorOffset(it[pagerState.currentPage])) }
        ) {
            tabs.forEachIndexed { index, tab ->
                Tab(
                    selected = index == pagerState.currentPage,
                    text = { Text(text = tab) },
                    onClick = {
                        coroutineScope.launch {
                            pagerState.scrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            userScrollEnabled = true
        ) {
            Contents(tab = tabs[pagerState.currentPage])
        }
    }
}

@Composable
fun Contents(tab: String) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        TextComponent(text = "$tab contents")
    }
}

