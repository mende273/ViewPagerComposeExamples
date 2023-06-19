package mende273.viewpagerexamples.util

import androidx.compose.ui.graphics.Color

fun getBackgroundColorForItem(page: Int): Color {
    return when (page % 2 == 0) {
        true -> Color.LightGray
        false -> Color.Gray
    }
}