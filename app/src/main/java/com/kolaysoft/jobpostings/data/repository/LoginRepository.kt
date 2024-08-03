package com.kolaysoft.jobpostings.data.repository

import com.kolaysoft.jobpostings.data.model.register.RegisterRequestData
import com.kolaysoft.jobpostings.data.model.register.RegisterResponseData
import retrofit2.Response

interface LoginRepository {

    suspend fun register(registerData: RegisterRequestData): Response<RegisterResponseData>
}