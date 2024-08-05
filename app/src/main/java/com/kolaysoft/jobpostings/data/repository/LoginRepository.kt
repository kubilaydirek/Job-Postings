package com.kolaysoft.jobpostings.data.repository

import com.kolaysoft.jobpostings.data.model.login.LoginRequestData
import com.kolaysoft.jobpostings.data.model.login.LoginResponseData
import com.kolaysoft.jobpostings.data.model.register.RegisterRequestData
import com.kolaysoft.jobpostings.data.model.register.RegisterResponseData
import retrofit2.Response

interface LoginRepository {

    suspend fun register(registerData: RegisterRequestData): Response<RegisterResponseData>

    suspend fun login(loginData: LoginRequestData): Response<LoginResponseData>
}