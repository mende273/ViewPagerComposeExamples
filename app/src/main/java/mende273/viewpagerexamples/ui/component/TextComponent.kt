package mende273.viewpagerexamples.ui.component

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mende273.viewpagerexamples.R

@Composable
fun TextComponent(text: String) {
    Text(
        modifier = Modifier
            .padding(6.dp),
        text = text,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
private fun TextComponentPreview() {
    TextComponent(text = stringResource(id = R.string.app_name))
}