package com.kolaysoft.jobpostings.data.RepositoryImp

import android.util.Log
import com.kolaysoft.jobpostings.data.model.login.LoginRequestData
import com.kolaysoft.jobpostings.data.model.login.LoginResponseData
import com.kolaysoft.jobpostings.data.model.register.RegisterRequestData
import com.kolaysoft.jobpostings.data.model.register.RegisterResponseData
import com.kolaysoft.jobpostings.data.repository.LoginRepository
import com.kolaysoft.jobpostings.data.service.ApiService
import okhttp3.ResponseBody
import retrofit2.Response
import javax.inject.Inject

class LoginRepositoryImp @Inject constructor(private val service: ApiService) : LoginRepository {

    override suspend fun register(registerData: RegisterRequestData): Response<RegisterResponseData> {
        return try {
            val result = service.register(registerData)
            if (result.code() == 200) {
                result
            } else {
                val errorBody = result.errorBody()?.string()
                Response.error(result.code(), ResponseBody.create(null, errorBody ?: "Hata içeriği yok"))
            }
        } catch (e: Exception) {
            Log.e("LoginRepositoryImp", "error $e")
            Response.error(500, ResponseBody.create(null, "Beklenmedik bir hata oluştu"))
        }
    }

    override suspend fun login(loginData: LoginRequestData): Response<LoginResponseData> {
        return try {
            val result = service.login(loginData)
            if (result.code() == 200) {
                result
            } else {
                val errorBody = result.errorBody()?.string()
                Response.error(result.code(), ResponseBody.create(null, errorBody ?: "Hata içeriği yok"))
            }
        } catch (e: Exception) {
            Log.e("LoginRepositoryImp", "error $e")
            Response.error(500, ResponseBody.create(null, "Beklenmedik bir hata oluştu"))
        }

    }

}