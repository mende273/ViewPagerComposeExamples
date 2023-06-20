package mende273.viewpagerexamples.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mende273.viewpagerexamples.util.getBackgroundColorForItem

@Composable
fun ViewPagerItem(page: Int, preferredBackground: Color? = null) {
    val backgroundColor = preferredBackground ?: getBackgroundColorForItem(page)

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
            .background(backgroundColor),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "Page: $page")
    }
}

@Preview
@Composable
private fun ViewPagerItemPreview() {
    ViewPagerItem(page = 0)
}