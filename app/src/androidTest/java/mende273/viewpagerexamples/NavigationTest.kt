package mende273.viewpagerexamples

import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.testing.TestNavHostController
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class NavigationTest {

    @get:Rule
    val composeTestRule = createComposeRule()
    private lateinit var navController: TestNavHostController

    @Before
    fun setupAppNavHost() {
        composeTestRule.setContent {
            navController = TestNavHostController(LocalContext.current)
            navController.navigatorProvider.addNavigator(ComposeNavigator())
            AppNavigation(
                navHostController = navController
            )
        }
    }

    @Test
    fun appNavHost_verifyStartDestination() {
        composeTestRule
            .onNodeWithTag("test_tag_home_screen")
            .assertIsDisplayed()
    }

    @Test
    fun appNavHost_verifyGoToHorizontalPagerScreen() {
        composeTestRule.onNodeWithTag("test_tag_horizontal_pager").performClick()
        val route = navController.currentDestination?.route
        Assert.assertEquals(route, Screen.HORIZONTAL_PAGER.route)
    }

    //TODO add tests for all screens
}