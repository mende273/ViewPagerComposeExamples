package mende273.viewpagerexamples.ui.component

import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import mende273.viewpagerexamples.Screen

@Composable
fun NavigationButtonComponent(
    modifier: Modifier = Modifier,
    screen: Screen,
    onItemClicked: (Screen) -> Unit
) {
    Button(
        modifier = modifier.testTag("test_tag_${screen.route}"),
        onClick = { onItemClicked.invoke(screen) }) {
        TextComponent(text = stringResource(id = screen.title))
    }
}

@Preview
@Composable
private fun NavigationButtonComponentPreview() {
    NavigationButtonComponent(screen = Screen.HORIZONTAL_PAGER_EXAMPLE, onItemClicked = {})
}