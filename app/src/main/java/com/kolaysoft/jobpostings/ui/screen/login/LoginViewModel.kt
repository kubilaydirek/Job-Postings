package com.kolaysoft.jobpostings.ui.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kolaysoft.jobpostings.data.RepositoryImp.LoginRepositoryImp
import com.kolaysoft.jobpostings.data.model.login.LoginRequestData
import com.kolaysoft.jobpostings.data.model.login.LoginResponseData
import com.kolaysoft.jobpostings.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(private val repository: LoginRepositoryImp) : ViewModel() {
    private val _loginResult = MutableStateFlow<Resource<LoginResponseData>>(Resource.Empty())
    val loginResult = _loginResult.asStateFlow()

    fun login(email: String, password: String) {
        viewModelScope.launch {
            try {
                _loginResult.value = Resource.Loading()
                val result = repository.login(LoginRequestData(email = email, password = password))
                if (result.code() == 200) {
                    _loginResult.value = Resource.Success(result.body())
                } else {
                    _loginResult.value = Resource.Error("Kullanıcı adı veya şifre hatalı")
                }
            } catch (e: Exception) {
                _loginResult.value = Resource.Error("Beklenmedik bir hata oluştu")

            }
        }
    }
}