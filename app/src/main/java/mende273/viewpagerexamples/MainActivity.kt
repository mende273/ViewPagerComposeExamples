package mende273.viewpagerexamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import mende273.viewpagerexamples.ui.component.TopBar
import mende273.viewpagerexamples.ui.screen.HomeScreen
import mende273.viewpagerexamples.ui.theme.ViewPagerComposeExamplesTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            var topBarTitle by rememberSaveable { mutableStateOf(Screen.HOME.title) }

            val modifier: Modifier = Modifier

            ViewPagerComposeExamplesTheme {
                Scaffold(
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.background)
                        .fillMaxSize(),
                    topBar = {
                        TopBar(
                            title = topBarTitle,
                            isBackButtonEnabled = topBarTitle != Screen.HOME.title,
                            onNavigateBack = {
                                navController.navigateUp()
                                topBarTitle = Screen.HOME.title
                            }
                        )
                    },
                    content = { innerPaddingValues ->
                        AppNavigation(
                            modifier = modifier,
                            paddingValues = innerPaddingValues,
                            navHostController = navController,
                            currentScreenTitle = {
                                topBarTitle = it
                            }
                        )
                    }
                )
            }
        }
    }
}


@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues = PaddingValues(),
    navHostController: NavHostController,
    currentScreenTitle: (Int) -> Unit = {}
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HOME.route,
        modifier.padding(paddingValues)
    ) {
        composable(Screen.HOME.route) {
            HomeScreen(modifier = Modifier.fillMaxSize(),
                onItemClicked = {
                    navHostController.navigate(it.route) {
                        launchSingleTop = true
                    }

                    currentScreenTitle.invoke(it.title)
                })
        }

        composable(Screen.HORIZONTAL_PAGER_EXAMPLE.route) {
            HorizontalPagerExampleScreen()
        }

        composable(Screen.HORIZONTAL_PAGER_WITH_BUTTONS_EXAMPLE.route) {
            HorizontalPagerWithButtonsExampleScreen()
        }

        composable(Screen.HORIZONTAL_PAGER_WITH_IMAGE_AND_DOTS_EXAMPLE.route) {
            HorizontalPagerWithImageAndDotsExampleScreen()
        }

        composable(Screen.VERTICAL_PAGER_EXAMPLE.route) {
            VerticalPagerExampleScreen()
        }
    }
}

@Composable
private fun HorizontalPagerExampleScreen() {
    Text(text = "HorizontalPagerExampleScreen")
}

@Composable
private fun HorizontalPagerWithButtonsExampleScreen() {
    Text(text = "HorizontalPagerWithButtonsExampleScreen")
}

@Composable
private fun HorizontalPagerWithImageAndDotsExampleScreen() {
    Text(text = "HorizontalPagerWithImageAndDotsExampleScreen")
}

@Composable
private fun VerticalPagerExampleScreen() {
    Text(text = "VerticalPagerExampleScreen")
}