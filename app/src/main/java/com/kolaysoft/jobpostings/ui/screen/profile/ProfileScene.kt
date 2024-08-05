package com.kolaysoft.jobpostings.ui.screen.profile

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kolaysoft.jobpostings.R
import com.kolaysoft.jobpostings.ui.components.BottomNavigation.BottomNavItem
import com.kolaysoft.jobpostings.ui.components.BottomNavigation.BottomNavigation


@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProfileScene(
    onNavigateToHome: () -> Unit,
    onNavigateToProfile: () -> Unit,
) {

    Scaffold(topBar = {
        TopAppBar(title = { Text(stringResource(R.string.profil)) })
    }, content = {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Profil")
        }
    }, bottomBar = {
        BottomNavigation(
            onNavigateToHome = { onNavigateToHome.invoke() },
            onNavigateToProfile = { onNavigateToProfile.invoke() },
            selectedItem = BottomNavItem.Profile
        )
    })

}