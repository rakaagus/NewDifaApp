package com.artforyou.difa.utils.enum

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.artforyou.difa.R

sealed class OnboardingPage(
    @DrawableRes val image: Int,
    @StringRes val title: Int,
    @StringRes val description: Int
) {
    object First: OnboardingPage(
        R.drawable.img_onboarding_1,
        R.string.onboard_page1_title,
        R.string.onboard_page1_desc
    )

    object Second: OnboardingPage(
        R.drawable.img_onboarding_2,
        R.string.onboard_page2_title,
        R.string.onboard_page2_desc
    )

    object Third: OnboardingPage(
        R.drawable.img_onboarding_3,
        R.string.onboard_page3_title,
        R.string.onboard_page3_desc
    )
}