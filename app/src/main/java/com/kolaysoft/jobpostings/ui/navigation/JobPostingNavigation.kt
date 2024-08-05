package com.kolaysoft.jobpostings.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kolaysoft.jobpostings.ui.screen.home.bottomNavigation
import com.kolaysoft.jobpostings.ui.screen.login.LoginScene
import com.kolaysoft.jobpostings.ui.screen.profile.profileNavigation
import com.kolaysoft.jobpostings.ui.screen.register.RegisterScene

@Composable
fun JobPostingNavigation(
    navController: NavHostController = rememberNavController()
) {
    val modifier = Modifier

    NavHost(navController = navController, startDestination = NavigationEnum.LOGIN.name) {
        composable(NavigationEnum.LOGIN.name) {
            LoginScene(
                onNavigateToHome = {
                    navController.navigate(NavigationEnum.HOME.name) {
                        popUpTo(NavigationEnum.LOGIN.name) { inclusive = true }
                    }
                },
                onNavigateToRegister = {
                    navController.navigate(NavigationEnum.REGISTER.name)
                },
                modifier = modifier
            )
        }
        composable(NavigationEnum.REGISTER.name) {
            RegisterScene(
                onClickPopBackStack = { navController.popBackStack() },
                modifier = modifier,
            )
        }
        bottomNavigation(navController);
        profileNavigation(navController)

    }
}