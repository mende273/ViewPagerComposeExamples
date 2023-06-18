package mende273.viewpagerexamples.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mende273.viewpagerexamples.Screen
import mende273.viewpagerexamples.ui.component.NavigationButtonComponent

@Composable
fun HomeScreen(modifier: Modifier = Modifier, onItemClicked: (Screen) -> Unit) {
    Box(
        modifier = modifier.testTag("test_tag_home_screen"),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .wrapContentSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Screen.values().filter { it.route != Screen.HOME.route }.forEach { screen ->
                NavigationButtonComponent(
                    Modifier.fillMaxWidth(),
                    screen = screen,
                    onItemClicked = {
                        onItemClicked.invoke(it)
                    })
            }
        }
    }
}

@Preview
@Composable
private fun HomeScreenPreview() {
    HomeScreen(onItemClicked = {})
}