package com.kolaysoft.jobpostings.ui.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.kolaysoft.jobpostings.ui.components.bottom_navigation.BottomNavigation


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScene(
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
) {

    Scaffold(
        content = {
            Column(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Profil")
            }
        },
        bottomBar = {
            BottomNavigation(
                onNavigateToHome = { onNavigateToHome.invoke() },
                onNavigateToProfile = { onNavigateToProfile.invoke() })
        }
    )

}