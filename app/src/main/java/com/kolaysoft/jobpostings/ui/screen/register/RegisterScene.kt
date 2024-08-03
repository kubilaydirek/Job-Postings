package com.kolaysoft.jobpostings.ui.screen.register

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.kolaysoft.jobpostings.R
import com.kolaysoft.jobpostings.ui.components.JobTextField
import com.kolaysoft.jobpostings.ui.components.JopPageCircleProgressIndicator
import com.kolaysoft.jobpostings.utils.Resource

@Composable
fun RegisterScene(modifier: Modifier) {
    val registerViewModel: RegisterViewModel = hiltViewModel()
    val username = remember { mutableStateOf("") }
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val passwordRetry = remember { mutableStateOf("") }

    val usernameError = remember { mutableStateOf(false) }
    val emailError = remember { mutableStateOf(false) }
    val passwordError = remember { mutableStateOf(false) }
    val passwordRetryError = remember { mutableStateOf(false) }

    val snackbarHostState = remember { SnackbarHostState() }

    val registerUiState = registerViewModel.uiRegisterState.collectAsState()

    LaunchedEffect(registerUiState.value) {

        if (registerUiState.value is Resource.Error && registerUiState.value.message != null) {
            snackbarHostState.showSnackbar(
                message = registerUiState.value.message ?: "Beklenmedik bir hata oluştu"
            )
        }
    }

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }, modifier = modifier.fillMaxSize()
    ) { paddingValues ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(paddingValues)
                .imePadding(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            JobTextField(
                fieldValue = username,
                labelText = stringResource(R.string.kullanici_adi),
                modifier = modifier,
                showError = usernameError.value
            )
            JobTextField(
                fieldValue = email,
                labelText = stringResource(R.string.email),
                modifier = modifier,
                showError = emailError.value
            )
            JobTextField(
                fieldValue = password,
                labelText = stringResource(R.string.sifre),
                isPassword = true,
                modifier = modifier,
                showError = passwordError.value
            )
            JobTextField(
                fieldValue = passwordRetry,
                labelText = stringResource(R.string.sifre_tekrari),
                isPassword = true,
                modifier = modifier,
                showError = passwordRetryError.value
            )
            Spacer(modifier = modifier.height(30.dp))
            Button(modifier = modifier.width(300.dp), onClick = {
                usernameError.value = username.value.isEmpty()
                emailError.value = email.value.isEmpty()
                passwordError.value = password.value.isEmpty()

                if (username.value.isNotEmpty() && email.value.isNotEmpty() && password.value.isNotEmpty()) {
                    registerViewModel.register(username.value, email.value, password.value)
                }
            }) {
                Text(text = stringResource(R.string.kayit_ol))
            }
        }

        if (registerUiState.value is Resource.Loading<*>) {
            JopPageCircleProgressIndicator()
        }
    }
}

