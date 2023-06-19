package mende273.viewpagerexamples.ui.screen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import mende273.viewpagerexamples.R
import mende273.viewpagerexamples.ui.component.ViewPagerButton
import mende273.viewpagerexamples.util.getBackgroundColorForItem

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerWithButtonsScreen() {
    val pageCount = 10
    val pagerState = rememberPagerState()
    val coroutineScope = rememberCoroutineScope()

    val shouldShowPrevButton by remember {
        derivedStateOf { pagerState.currentPage > 0 }
    }

    val shouldShowNextButton by remember {
        derivedStateOf { pagerState.currentPage < pageCount - 1 }
    }

    val horizontalArrangement by remember {
        derivedStateOf {
            if (pagerState.currentPage > 0) {
                Arrangement.SpaceBetween
            } else if (pagerState.currentPage < pageCount - 1) {
                Arrangement.End
            } else {
                Arrangement.Start
            }
        }
    }

    Box(modifier = Modifier) {
        HorizontalPager(pageCount = pageCount, state = pagerState) { page ->
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

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(16.dp), horizontalArrangement = horizontalArrangement
        ) {

            if (shouldShowPrevButton) {
                ViewPagerButton(title = stringResource(id = R.string.prev_button), onButtonClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage - 1)
                    }
                })
            }

            if (shouldShowNextButton) {
                ViewPagerButton(title = stringResource(id = R.string.next_button),
                    onButtonClick = {
                        coroutineScope.launch {
                            pagerState.animateScrollToPage(pagerState.currentPage + 1)
                        }
                    })
            }
        }
    }
}