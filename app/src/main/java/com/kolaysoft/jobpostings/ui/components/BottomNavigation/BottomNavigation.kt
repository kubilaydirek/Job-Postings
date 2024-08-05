package com.kolaysoft.jobpostings.ui.components.BottomNavigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults.containerColor
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun BottomNavigation(
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
    selectedItem: BottomNavItem
) {

    val items = listOf(
        BottomNavItem.Home, BottomNavItem.Profile
    )

    NavigationBar {
        items.forEach { item ->
            AddItem(
                screen = item,
                onNavigateToHome = { onNavigateToHome.invoke() },
                onNavigateToProfile = { onNavigateToProfile.invoke() }, selectedItem = selectedItem == item
            )

        }
    }

}

@Composable
fun RowScope.AddItem(
    screen: BottomNavItem,
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
    selectedItem: Boolean
) {
    NavigationBarItem(
        selected = selectedItem,
        onClick = {
            when (screen) {
                is BottomNavItem.Home -> onNavigateToHome.invoke()
                is BottomNavItem.Profile -> onNavigateToProfile.invoke()
            }
        },
        icon = { Icon(painter = painterResource(id = screen.icon), contentDescription = "") },
        label = { Text(text = screen.title) },
        alwaysShowLabel = selectedItem,
        colors = NavigationBarItemDefaults.colors(selectedIconColor = Color.White, indicatorColor = Color.Gray),
    )

}

@Preview
@Composable
fun PreviewBottomNavigation() {
    BottomNavigation(
        onNavigateToHome = { },
        onNavigateToProfile = { },
        selectedItem = BottomNavItem.Home
    )
}