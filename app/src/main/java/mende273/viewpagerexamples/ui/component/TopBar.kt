package mende273.viewpagerexamples.ui.component

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import mende273.viewpagerexamples.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    @StringRes title: Int,
    isBackButtonEnabled: Boolean = false,
    onNavigateBack: () -> Unit = {}
) {
    TopAppBar(
        title = { Text(text = stringResource(id = title)) },
        navigationIcon = {
            if (isBackButtonEnabled) {
                BackNavigationButton(onBackPressed = {
                    onNavigateBack.invoke()
                })
            }
        }
    )
}

@Composable
private fun BackNavigationButton(onBackPressed: () -> Unit) {
    IconButton(onClick = { onBackPressed.invoke() }) {
        Icon(Icons.AutoMirrored.Filled.ArrowBack, "back icon button")
    }
}

@Preview
@Composable
private fun TopBarPreview() {
    TopBar(title = R.string.app_name)
}

@Preview
@Composable
private fun TopBarWithBackEnabledPreview() {
    TopBar(title = R.string.app_name, isBackButtonEnabled = true)
}

@Preview
@Composable
private fun BackNavigationButtonPreview() {
    BackNavigationButton {}
}