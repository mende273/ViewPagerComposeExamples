package mende273.viewpagerexamples.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun TabIndicator(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .wrapContentWidth(align = Alignment.CenterHorizontally)
            .padding(2.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.secondary)
            .size(10.dp)
    )
}