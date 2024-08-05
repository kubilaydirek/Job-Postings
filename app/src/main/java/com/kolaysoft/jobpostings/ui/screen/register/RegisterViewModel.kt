package com.kolaysoft.jobpostings.ui.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.kolaysoft.jobpostings.data.RepositoryImp.LoginRepositoryImp
import com.kolaysoft.jobpostings.data.model.ApiErrorResponse
import com.kolaysoft.jobpostings.data.model.register.RegisterRequestData
import com.kolaysoft.jobpostings.data.model.register.RegisterResponseData
import com.kolaysoft.jobpostings.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(private val repository: LoginRepositoryImp) : ViewModel() {
    private val _uiRegisterState = MutableStateFlow<Resource<RegisterResponseData>>(Resource.Empty())
    val uiRegisterState = _uiRegisterState.asStateFlow()

    fun register(username: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                _uiRegisterState.value = Resource.Loading()
                val response =
                    repository.register(RegisterRequestData(username = username, email = email, password = password))
                if (response.isSuccessful) {
                    val registerResponseData = response.body()
                    _uiRegisterState.value = Resource.Success(registerResponseData)
                } else {
                    val errorBody = response.errorBody()?.string()
                    val apiErrorResponse = errorBody?.let {
                        Gson().fromJson(it, ApiErrorResponse::class.java)
                    }
                    var errorMessage = apiErrorResponse?.error?.message!!
                    if (errorMessage == "INVALID_EMAIL") {
                        errorMessage = "Geçersiz eposta"
                    } else if (errorMessage == "EMAIL_EXISTS") {
                        errorMessage = "Eposta zaten kullanılmaktadır"
                    }
                    _uiRegisterState.value = Resource.Error(errorMessage)
                }
            } catch (e: Exception) {
                println("Error: $e")
                _uiRegisterState.value = Resource.Error("Beklenmedik bir hata oluştu")
            }

        }
    }
}


