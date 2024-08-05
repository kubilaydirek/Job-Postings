package com.kolaysoft.jobpostings.ui.screen.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kolaysoft.jobpostings.R
import com.kolaysoft.jobpostings.ui.components.JobButton
import com.kolaysoft.jobpostings.ui.components.JobTextField
import com.kolaysoft.jobpostings.ui.components.JopPageCircleProgressIndicator
import com.kolaysoft.jobpostings.ui.navigation.NavigationEnum
import com.kolaysoft.jobpostings.utils.Resource

@Composable
fun LoginScene(
    onNavigateToHome: ()-> Unit,
    onNavigateToRegister: ()-> Unit,
    modifier: Modifier,
) {
    val viewModel: LoginViewModel = hiltViewModel()
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    val usernameError = remember { mutableStateOf(false) }
    val passwordError = remember { mutableStateOf(false) }
    val loginResult = viewModel.loginResult.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    LaunchedEffect(loginResult.value) {
        if (loginResult.value is Resource.Error) {
            snackbarHostState.showSnackbar(message = loginResult.value.message ?: "Giriş Yapılamadı")
        } else if (loginResult.value is Resource.Success && loginResult.value.data?.idToken != "") {
            onNavigateToHome.invoke()
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }, modifier = modifier.fillMaxSize()

    ) { paddingValues ->
        Column(
            modifier = modifier
                .padding(paddingValues)
                .imePadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = stringResource(R.string.giris_yap),
                style = TextStyle(fontSize = 25.sp, fontWeight = FontWeight.Bold)
            )
            JobTextField(
                fieldValue = username,
                labelText = stringResource(id = R.string.email),
                modifier = modifier,
                showError = usernameError.value
            )
            JobTextField(
                fieldValue = password,
                labelText = stringResource(id = R.string.sifre),
                modifier = modifier,
                showError = passwordError.value
            )
            Spacer(modifier = modifier.height(15.dp))
            JobButton(modifier = modifier, buttonText = stringResource(R.string.giris_yap)) {
                usernameError.value = username.value.isEmpty()
                passwordError.value = password.value.isEmpty()

                if (username.value.isNotEmpty() && password.value.isNotEmpty()) {
                    viewModel.login(email = username.value, password = password.value)
                }
            }
            Spacer(modifier = modifier.height(15.dp))
            Row(horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Divider(
                    modifier = modifier
                        .height(3.dp)
                        .weight(0.3f)
                )
                Text(
                    text = stringResource(R.string.veya),
                    modifier = modifier.padding(15.dp),
                    style = TextStyle(fontSize = 15.sp)
                )
                Divider(
                    modifier = modifier
                        .height(3.dp)
                        .weight(0.3f)
                )
            }
            TextButton(
                onClick = onNavigateToRegister
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = stringResource(R.string.kayit_olmak_icin))
                    Text(
                        text = stringResource(R.string.tiklayin),
                        style = TextStyle(fontWeight = FontWeight.Bold, color = Color.Black)
                    )
                }

            }
        }

        if (loginResult.value is Resource.Loading) {
            JopPageCircleProgressIndicator()
        }
    }
}