package com.kolaysoft.jobpostings.ui.components.BottomNavigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigation(
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
) {

    val items = listOf(
        BottomNavItem.Home, BottomNavItem.Profile
    )

    NavigationBar {
        items.forEach { item ->
            AddItem(
                screen = item,
                onNavigateToHome = { onNavigateToHome.invoke() },
                onNavigateToProfile = { onNavigateToProfile.invoke() })

        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
) {
    NavigationBarItem(
        selected = true,
        onClick = {
            when (screen) {
                is BottomNavItem.Home -> onNavigateToHome.invoke()
                is BottomNavItem.Profile -> onNavigateToProfile.invoke()
            }
        },
        icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = "") },
        label = { Text(text = screen.title) },
        alwaysShowLabel = true
    )

}

@Preview
@Composable
fun PreviewBottomNavigation() {
    BottomNavigation(onNavigateToHome = {}, onNavigateToProfile = {})
}