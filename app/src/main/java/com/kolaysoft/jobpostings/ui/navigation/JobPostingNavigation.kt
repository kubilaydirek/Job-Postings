package com.kolaysoft.jobpostings.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kolaysoft.jobpostings.ui.screen.home.HomeScene
import com.kolaysoft.jobpostings.ui.screen.login.LoginScene
import com.kolaysoft.jobpostings.ui.screen.register.RegisterScene

@Composable
fun JobPostingNavigation() {
    val navController = rememberNavController()
    val modifier = Modifier

    NavHost(navController = navController, startDestination = NavigationEnum.LOGIN.name) {
        composable(NavigationEnum.LOGIN.name) {
            LoginScene(navController = navController, modifier = modifier)
        }
        composable(NavigationEnum.REGISTER.name) {
            RegisterScene(modifier = modifier, navController)
        }
        composable(NavigationEnum.HOME.name) {
            HomeScene()
        }
    }
}