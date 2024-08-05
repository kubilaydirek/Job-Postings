package com.kolaysoft.jobpostings.ui.components.bottom_navigation

import com.kolaysoft.jobpostings.R

sealed class BottomNavItem(
    var title: String,
    var icon: Int
) {
    object Home : BottomNavItem(title = "Anasayfa", icon = R.drawable.home_icon)
    object Profile : BottomNavItem(title = "Profil", icon = R.drawable.profile_icon)
}