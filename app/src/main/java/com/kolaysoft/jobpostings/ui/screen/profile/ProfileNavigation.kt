package com.kolaysoft.jobpostings.ui.screen.profile

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kolaysoft.jobpostings.ui.navigation.NavigationEnum

fun NavGraphBuilder.profileNavigation(navController: NavController) {
    composable(NavigationEnum.PROFILE.name) {
        ProfileScene(
            onNavigateToHome = { navController.navigate(NavigationEnum.HOME.name) },
            onNavigateToProfile = { navController.navigate(NavigationEnum.PROFILE.name) }
        )
    }
}