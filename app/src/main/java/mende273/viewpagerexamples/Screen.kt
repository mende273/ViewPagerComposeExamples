package mende273.viewpagerexamples

import androidx.annotation.StringRes

enum class Screen(val route: String, @StringRes val title: Int) {
    HOME("home", R.string.screen_home_title),
    HORIZONTAL_PAGER("horizontal_pager", R.string.screen_horizontal_pager_title),
    HORIZONTAL_PAGER_WITH_BUTTONS("horizontal_pager_with_buttons", R.string.screen_horizontal_pager_with_buttons_title),
    HORIZONTAL_PAGER_WITH_IMAGE_AND_DOTS("horizontal_pager_with_image_and_dots", R.string.screen_horizontal_pager_with_image_and_dots_title),
    VERTICAL_PAGER("vertical_pager", R.string.screen_vertical_pager_title)
}