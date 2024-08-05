package com.kolaysoft.jobpostings.ui.screen.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.kolaysoft.jobpostings.ui.navigation.NavigationEnum
import com.kolaysoft.jobpostings.ui.screen.home.HomeScene
import com.kolaysoft.jobpostings.ui.screen.profile.ProfileScene

fun NavGraphBuilder.bottomNavigation(navController: NavController) {
    composable(NavigationEnum.HOME.name) {
        HomeScene(
            onNavigateToHome = { navController.navigate(NavigationEnum.HOME.name) },
            onNavigateToProfile = { navController.navigate(NavigationEnum.PROFILE.name) })
    }
    composable(NavigationEnum.PROFILE.name) {
        ProfileScene(
            onNavigateToHome = { navController.navigate(NavigationEnum.HOME.name) },
            onNavigateToProfile = { navController.navigate(NavigationEnum.PROFILE.name) }
        )
    }
}