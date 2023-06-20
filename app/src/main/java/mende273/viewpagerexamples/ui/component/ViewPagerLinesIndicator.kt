package mende273.viewpagerexamples.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ViewPagerLinesIndicator(
    modifier: Modifier = Modifier,
    pageCount: Int,
    currentPageIteration: Int
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Start
    ) {
        repeat(pageCount) { iteration ->

            val color = if (currentPageIteration == iteration) Color.DarkGray else Color.LightGray
            Box(
                modifier = Modifier
                    .padding(4.dp)
                    .clip(RoundedCornerShape(2.dp))
                    .background(color)
                    .weight(1f)
                    .height(4.dp)
            )
        }
    }
}

@Preview
@Composable
private fun ViewPagerLinesIndicatorPreview() {
    ViewPagerLinesIndicator(pageCount = 5, currentPageIteration = 2)
}