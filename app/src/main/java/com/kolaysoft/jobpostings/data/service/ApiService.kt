package com.kolaysoft.jobpostings.data.service

import com.kolaysoft.jobpostings.data.model.login.LoginRequestData
import com.kolaysoft.jobpostings.data.model.login.LoginResponseData
import com.kolaysoft.jobpostings.data.model.register.RegisterRequestData
import com.kolaysoft.jobpostings.data.model.register.RegisterResponseData
import com.kolaysoft.jobpostings.utils.AppUtils
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("v1/accounts:signUp?key=${AppUtils.projectKey}")
    suspend fun register(@Body body: RegisterRequestData): Response<RegisterResponseData>

    @POST("v1/accounts:signInWithPassword?key=${AppUtils.projectKey}")
    suspend fun login(@Body body: LoginRequestData): Response<LoginResponseData>

}