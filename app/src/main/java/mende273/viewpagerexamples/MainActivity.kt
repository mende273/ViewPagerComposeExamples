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
import mende273.viewpagerexamples.ui.screen.HorizontalPagerScreen
import mende273.viewpagerexamples.ui.screen.HorizontalPagerWithButtonsScreen
import mende273.viewpagerexamples.ui.screen.HorizontalPagerWithDotsIndicatorScreen
import mende273.viewpagerexamples.ui.screen.HorizontalPagerWithLinesIndicatorScreen
import mende273.viewpagerexamples.ui.screen.ScrollableTabsWithHorizontalPagerScreen
import mende273.viewpagerexamples.ui.screen.TabsWithHorizontalPagerScreen
import mende273.viewpagerexamples.ui.screen.VerticalPagerScreen
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

        composable(Screen.HORIZONTAL_PAGER.route) {
            HorizontalPagerScreen()
        }

        composable(Screen.HORIZONTAL_PAGER_WITH_BUTTONS.route) {
            HorizontalPagerWithButtonsScreen()
        }

        composable(Screen.HORIZONTAL_PAGER_WITH_DOTS_INDICATOR.route) {
            HorizontalPagerWithDotsIndicatorScreen()
        }

        composable(Screen.HORIZONTAL_PAGER_WITH_LINES_INDICATOR.route) {
            HorizontalPagerWithLinesIndicatorScreen()
        }

        composable(Screen.TABS_WITH_HORIZONTAL_PAGER.route) {
            TabsWithHorizontalPagerScreen()
        }

        composable(Screen.SCROLLABLE_TABS_WITH_HORIZONTAL_PAGER.route) {
            ScrollableTabsWithHorizontalPagerScreen()
        }

        composable(Screen.VERTICAL_PAGER.route) {
            VerticalPagerScreen()
        }
    }
}