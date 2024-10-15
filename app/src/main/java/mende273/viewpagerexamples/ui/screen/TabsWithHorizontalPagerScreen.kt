package mende273.viewpagerexamples.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch
import mende273.viewpagerexamples.ui.component.TabIndicator
import mende273.viewpagerexamples.ui.component.TextComponent

@Composable
fun TabsWithHorizontalPagerScreen() {
    val tabs = enumValues<Tab>()

    val pagerState = rememberPagerState(pageCount = { tabs.size })
    val coroutineScope = rememberCoroutineScope()

    Column {
        TabRow(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground,
            selectedTabIndex = pagerState.currentPage,
            divider = { HorizontalDivider(color = MaterialTheme.colorScheme.background) },
            indicator = { TabIndicator(Modifier.tabIndicatorOffset(it[pagerState.currentPage])) }
        ) {
            tabs.forEachIndexed { index, item ->
                Tab(
                    selected = index == pagerState.currentPage,
                    text = { Text(text = item.title) },
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
            TabContents(tab = tabs[pagerState.currentPage])
        }
    }
}

@Composable
fun TabContents(tab: Tab) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        TextComponent(text = "${tab.title} contents")
    }
}

enum class Tab(val title: String) {
    TAB_1("Tab 1"), TAB_2("Tab 2"), TAB_3("Tab 3")
}
