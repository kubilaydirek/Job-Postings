package com.kolaysoft.jobpostings.ui.screen.home.bottom_navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController

@Composable
fun BottomNavigation(navController: NavController) {

    val items = listOf(
        BottomNavItem.Home, BottomNavItem.Profile
    )
    NavigationBar {
        items.forEach { item ->
            AddItem(screen = item, navController)

        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    navController: NavController,
) {
    NavigationBarItem(
        selected = true,
        onClick = {
            when (screen) {
                is BottomNavItem.Home -> navController.navigate("home")
                is BottomNavItem.Profile -> navController.navigate("profile")
            }
        },
        icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = "") },
        label = { Text(text = screen.title) },
        alwaysShowLabel = true
    )

}
